/*
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. 
 * If a copy of the MPL was not distributed with this file, You can obtain one at
 *  http://mozilla.org/MPL/2.0/. 
 *
 * Copyright 2000, 2001, 2002, 2003, 2004, 2005, 2006 National Research Council of Canada 
 * 
 * This software was initially developed at the National Research Council of Canada (NRC).
 *
 * THE NATIONAL RESEARCH COUNCIL OF CANADA MAKES NO REPRESENTATIONS OR
 * WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT.
 * THE NATIONAL RESEARCH COUNCIL OF CANADA SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 *
 *
 */


package nrc.fuzzy;

import java.io.*;

/**
 * An implementation of the FuzzySetFunction interface to provide
 * a class with the ability to generate a FuzzySet that is a
 * Z-shaped curve with membership value 1 on the upper left to 0 on the lower right.
 * This class is typically used when constructing instances of the classes
 * RFuzzySet and LRFuzzySet. The PIFuzzySet for example is constructed using
 * the SFunction to create its left half and the ZFunction to create its
 * right half.
  * <br> <br>
 * The ZFunction membership values (y values) are calculated as follows:
 * <br>
 * <code>
 * 
 * 		leftX is the lower left X value 
 * 		rightX is the upper right X value
 * 		midpoint is the x value half way between leftX and rightX
 * 		sqr is the square root function
 * 
 *      if x is <= leftX then y = 1.0
 *      if x is between leftX and the midpoint 
 * 				then y = 1 - 2*sqr(((x - leftX)/(rightX - leftX)))
 *      if x is midpoint then y = 0.5
 *      if x is between the midpoint and rightX 
 * 				then y = 2*sqr(((x - rightX)/(rightX - leftX)))
 *      if x is >= rightX then y = 0.0
 *
 * </code>
 * 
 * @author Bob Orchard
 *
 * @see RFuzzySet
 * @see LRFuzzySet
 * @see PIFuzzySet
 * @see SFunction
 */
public class ZFunction implements FuzzySetFunction, Serializable
{

    /**
     * This value is used to determine the number of points that will be
     * in the Z-shaped fuzzy set generated by the 
     * <code>generateFuzzySet(double leftX, double rightX)</code> method,
     * unless it has a value of < 3, in which case the value of static (class)
     * variable, zFunctionDefaultNumPoints, will be used. This allows 
     * each instance of the ZFunction to determine its own value for the number
     * of points to be generated. Initially it is set to have the value 0 so
     * that the zFunctionDefaultNumPoints value is used. If the number 
     * is even it will be set to the next higher odd value 
     * (to maintain symmetry for the Z curve).
     *
     */
    int defaultNumPoints = 0;
    
    /**
     * This value is used to determine the number of points that will be
     * in the Z-shaped fuzzy set generated by the 
     * <code>generateFuzzySet(double leftX, double rightX)</code> method
     * when the local instance variable defaultNumPoints has not been
     * set or is < 3. Initially it is set to have the value 9. If the number 
     * is even it will be set to the next higher odd value 
     * (to maintain symmetry for the S curve).
     * 
     */
    static int zFunctionDefaultNumPoints;

    /*===============================================
     *
     * CONSTRUCTORS
     *
     *==============================================*/

    /**
     * Creates an instance of a ZFunction that is used to generate Fuzzysets
     * with a Z-shape. A FuzzySet created will have a 1 value at its upper 
     * left and a 0 value at its lower right.
     * 
     */
    public ZFunction()
    {}

    /**
     * Creates an instance of an SZFunction that is used to generate Fuzzysets
     * with a Z-shape. A FuzzySet created will have a 1 value at its upper left 
     * and a 1 value at its lower right. When created with this constructor a value for the number
     * of points to be used when creating the Z-shaped fuzzy set is set (defaultNumPoints).
     * 
     * @param numPoints the number of points to use when creating the Z-shaped FuzzySet.
     */
    public ZFunction(int numPoints)
    {
        setNumPoints(numPoints);
    }
    
    static 
    {
        zFunctionDefaultNumPoints = 9;
    }    

    /*===============================================
     *
     * METHODS
     *
     *==============================================*/

    /**
     * Creates a FuzzySet with a Z-shape such that the membership value is
     * 1 at the leftX value and 0 at the rightX value. The number of points in
     * the generated FuzzySet is determined by the settings of the local instance 
     * variable <code>defaultNumPoints</code> and the static class variable 
     * <code>zFunctionDefaultNumPoints</code>.
     *
     * @param leftX  the bottom left x value of the Z-shaped curve.
     * @param rightX the upper right x value of the Z-shaped curve.
     */
    public FuzzySet generateFuzzySet(double leftX, double rightX)
    {
        if(defaultNumPoints < 3) return(generateFuzzySet(leftX, rightX, zFunctionDefaultNumPoints));
        else                     return(generateFuzzySet(leftX, rightX, defaultNumPoints));
    }

    /**
     * Creates a FuzzySet with a Z-shape such that the membership value is
     * 1 at the leftX value and 0 at the rightX value. The number of points in
     * the generated FuzzySet is determined by the the paramter numberOfPoints
     * if it is acceptible (>= 3) or it is set to 3. If the number is even it will be set
     * to the next higher odd value (to maintain symmetry for the S curve).
     * 
     * @param leftX  the bottom left x value of the Z-shaped curve.
     * @param rightX the upper right x value of the Z-shaped curve.
     * @param numberOfPoints the number of points to be used when generating the 
     *               Z-shaped curve.
     */
    public FuzzySet generateFuzzySet(double leftX, double rightX, int numberOfPoints)
    {
        double deltaX, X;
        double flexPoint = (leftX + rightX)/2;
        int numPoints = returnCorrectedNumPoints(numberOfPoints);
        int middle = numPoints/2;
        
        FuzzySet fs = new FuzzySet(numPoints);
        fs.numPoints = numPoints;

        fs.set[0] = new SetPoint(leftX, 1.0);
        
        X = deltaX = (rightX - leftX) / (numPoints-1);
        for(int i=1; i<middle; i++){
            fs.set[i] = new SetPoint(leftX + X, zMembership(leftX + X, leftX, flexPoint, rightX));
            X += deltaX;
        }

        fs.set[middle] = new SetPoint(flexPoint, 0.5);
        X = deltaX;

        for(int i=(middle + 1); i<numPoints-1; i++){
            fs.set[i] = new SetPoint(flexPoint + X, zMembership(flexPoint + X, leftX, flexPoint, rightX));
            X += deltaX;
        }

        fs.set[numPoints-1] = new SetPoint(rightX, 0.0);
        fs.simplifySet();
        return(fs);
    }

    /**
     * Calculates a membership value for an X value in the Z-shaped function.
     * Note that it uses 1-SFunction.sMembership(...) since S and Z shapes
     * are the complement of each other.
     *
     * @param x         the x value at which we want to get the membership value
     * @param leftX     the leftmost X value of the Z-shaped curve
     * @param flexPoint the point of flex (symmetry) for the curve
     * @param rightX    the rightmost X value of the Z-shaped curve
     */
    protected static double zMembership(double x, double leftX, double flexPoint, double rightX)
    {
        return( 1 - SFunction.sMembership(x, leftX, flexPoint, rightX) );
    }


    /*=====================================
     *
     * STATIC CONTROL METHODS
     *
     *===================================*/

    /**
     * Sets the value of the defaultNumPoints variable.
     * This value is used to determine the number of points that will be
     * in the Z-shaped fuzzy set generated by the 
     * <code>generateFuzzySet(double leftX, double rightX)</code> method,
     * unless it has a value of < 3, in which case the value of static (class)
     * variable, zFunctionDefaultNumPoints, will be used. This allows 
     * each instance of the ZFunction to determine its own value for the number
     * of points to be generated. Initially it is set to have the value 0 so
     * that the zFunctionDefaultNumPoints value is used. If the number 
     * is even it will be set to the next higher odd value 
     * (to maintain symmetry for the Z curve).
     */
    public void setNumPoints(int numPoints)
    {
        if(numPoints < 3)               defaultNumPoints = 3;
        else if((numPoints % 2) != 1)   defaultNumPoints = numPoints + 1;
        else                            defaultNumPoints = numPoints;
    }

    /**
     * Sets the value of the zFunctionDefaultNumPoints static (class) variable.
     * This value is used to determine the number of points that will be
     * in the Z-shaped fuzzy set generated by the 
     * <code>generateFuzzySet(double leftX, double rightX)</code> method
     * when the local instance variable defaultNumPoints has not been
     * set or is < 3. Initially it is set to have the value 9. If the number 
     * is even it will be set to the next higher odd value 
     * (to maintain symmetry for the Z curve).
     * 
     */
    public static void setDefaultNumberOfPoints(int numPoints)
    {
        if(numPoints < 3)               zFunctionDefaultNumPoints = 3;
        else if((numPoints % 2) != 1)   zFunctionDefaultNumPoints = numPoints + 1;
        else                            zFunctionDefaultNumPoints = numPoints;
    }


    /*=========================================
     *
     * METHODS TO MAKE LIFE A LITTLE EASIER
     *
     *=======================================*/

    /** 
     * Keeps the values for the number of points in the S-shaped curve to
     * be >= 3 and odd.
     *
     * @param numPoints the integer value to be constrained to be >= 3 and odd.
     * 
     */
    protected int returnCorrectedNumPoints(int numPoints)
    {
        if(numPoints < 3)        return(3);
        if((numPoints % 2) != 1) return(numPoints+1);

        return(numPoints);
    }
}