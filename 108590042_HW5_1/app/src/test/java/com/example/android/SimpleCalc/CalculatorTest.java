/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void testPowPostiveInt() {
        double result = mCalculator.pow(2d, 5d);
        assertEquals(result, 32d, 0.001d);
    }

    @Test
    public void testPowFirstNegativeInt() {
        double result = mCalculator.pow(-2d, 5d);
        assertEquals(result, -32d, 0.001d);
    }

    @Test
    public void testPowSecondNegativeInt() {
        double result = mCalculator.pow(2d, -5d);
        assertEquals(result, 1/32d, 0.001d);
    }

    @Test
    public void testZeroPosInt() {
        double result = mCalculator.pow(0d, 2d);
        assertEquals(result, 0d, 0.001d);
    }

    @Test
    public void testPosZero() {
        double result = mCalculator.pow(2d, 0);
        assertEquals(result, 1, 0.001d);
    }

    @Test
    public void testZeroNegOne() {
        double result = mCalculator.pow(0d, -1d);
        assertEquals(result, Double.POSITIVE_INFINITY, 0.001d);
    }

    @Test
    public void testMinusZeroNegInt() {
        double result = mCalculator.pow(-0d, -5d);
        assertEquals(result, Double.NEGATIVE_INFINITY, 0.001d);
    }

}