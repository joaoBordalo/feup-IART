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
 * An abstract class that can be sub-classed to provide
 * an execute method that accepts a FuzzyRule object and 
 * returns a FuzzyValueVector composed of the actual output FuzzyValues
 * for the rule (using the implication operator and composition operator
 * that the specific interface implements). For example, the execute method
 * may implement rule execution using the Mamdani Min inference operator
 * and Max-Min composition. This is due to the FuzzyRuleExecutorInterface interface.
 * It must also implement the cloneable interface and provide a clone method so
 * that we can guarantee that when a Rule is created it gets a unique
 * instance of the rule executor.
 *
 * All FuzzyRules have a FuzzyRuleExecutor associated with them. This defines the 
 * method (algorithm) that will be used for calculating the output FuzzyValues
 * of a rule, given the antecedents, inputs and conclusions in the FuzzyRule.
 *
 * In general each FuzzyRule must have a unique instance of a FuzzyRuleExecutor
 * associated with it. This will allow the Rule Executors to save state between
 * firings of the same rule and when possible avoid redoing some calculations,
 * after testing that the rule contents (antecedents, inputs, and conclusions)
 * have not changed enough to invalidate previous calculations. For example, 
 * the MamdaniMinMaxMinRuleExecutor implements the Mamdani Min inference operator
 * and the Max-Min composition operator to calculate a rule's outputs. This 
 * method has the rather nice property that the outputs are generated from the
 * conclusions by 'clipping' them at a value that is calculated as the minimum
 * of the maximum membership values of the intersections of the fuzzy value 
 * antecedent and input pairs. So one can calculate the intersections of the pairs
 * get the maximum membership value for each intersection and find the minimum of these.
 * Should the rule be fired a second time and the antecedents and inputs have not 
 * changed, it is only necessary to clip the consequents, avoiding some
 * expensive calculations. 
 * 
 * @author Bob Orchard
 *
 * @see MamdaniMinMaxMinRuleExecutor
 * @see LarsenProductMaxMinRuleExecutor
 * @see FuzzyRule
 */
public abstract class FuzzyRuleExecutor implements FuzzyRuleExecutorInterface, 
                        Cloneable, Serializable
{
}
