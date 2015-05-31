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
 * Used to build specialized FuzzySets that in have a shape similar to
 * the character S with a 0 at the left edge and 1 at the right edge. 
 * The diagram below shows an SFuzzySet.
 * <br> <br>
 * <img src = "NetGraphics/SFuzzySet.gif">
 * <br> <br>
 * Note that the Constructors have been defined to make the generation of 
 * such curves as simple as possible. Only the left and right edges of the 
 * curve need be specified (with an optional constructor that allows the number of
 * points on the curve approximation to be specified if necessary).
 *
 * @author Bob Orchard
 *
 * @see FuzzySet
 * @see LFuzzySet
 * @see SFunction
 *
 */
public class SFuzzySet extends LFuzzySet implements Serializable
{    
    private static SFunction ssf = new SFunction();

    /**
     * Generate a FuzzySet with an S shape. 
     *
     * @param leftEdge the start of the curve at the left with a membership value of 0
     * @param rightEdge the end of the curve at the right with a membership value of 1
     * @exception XValuesOutOfOrderException if the leftEdge argument is less than the
     *                rightEdge argument
     */

    public SFuzzySet(double leftEdge, double rightEdge) throws XValuesOutOfOrderException {
        super(leftEdge, rightEdge, ssf);
    }

    /**
     * Generate a FuzzySet with an S shape. 
     *
     * @param leftEdge the start of the curve at the left with a membership value of 0
     * @param rightEdge the end of the curve at the right with a membership value of 1
     * @param numPoints the number of points to use to approximate the S shape
     * @exception XValuesOutOfOrderException if the leftEdge argument is less than the
     *                rightEdge argument
     */
    public SFuzzySet(double leftEdge, double rightEdge, int numPoints) throws XValuesOutOfOrderException {
        super(leftEdge, rightEdge, new SFunction(numPoints));
    }
}


