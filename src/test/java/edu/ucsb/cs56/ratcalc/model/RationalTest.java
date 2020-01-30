package edu.ucsb.cs56.ratcalc.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1;

    @Before 
    public void setUp() {
	r_5_15 = new Rational(5,15);
	r_24_6 = new Rational(24,6);
	r_3_7  = new Rational(3,7);
	r_13_4 = new Rational(13,4);
	r_20_25 = new Rational(20,25);
	r_0_1 = new Rational(0,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
	Rational r = new Rational(1,0);
    }

    @Test
    public void test_getNumerator_20_25() {
	assertEquals(4, r_20_25.getNumerator());
    }

    @Test
    public void test_getNumerator_13_4() {
	assertEquals(13, r_13_4.getNumerator());
    }

    @Test
    public void test_getDenominator_20_25() {
	assertEquals(5, r_20_25.getDenominator());
    }

    @Test
    public void test_getDenominator_13_4() {
	assertEquals(4, r_13_4.getDenominator());
    }

    @Test
    public void test_toString_5_15() {
	assertEquals("1/3",r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
	assertEquals("4",r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
	assertEquals("3/7",r_3_7.toString());
    }

    @Test
    public void test_toString_20_25() {
	assertEquals("4/5",r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
	assertEquals("0",r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
	assertEquals(5, Rational.gcd(5,15));
    }

    @Test
    public void test_gcd_15_5() {
	assertEquals(5, Rational.gcd(15,5));
    }

    @Test
    public void test_gcd_24_6() {
	assertEquals(6, Rational.gcd(24,6));
    }

    @Test
    public void test_gcd_17_5() {
	assertEquals(1, Rational.gcd(17,5));
    }

    @Test
    public void test_gcd_1_1() {
	assertEquals(1, Rational.gcd(1,1));
    }

    @Test
    public void test_gcd_20_25() {
	assertEquals(5, Rational.gcd(20,25));
    }

    @Test
    public void test_lcm_20_25() {
	assertEquals(100, Rational.lcm(20,25));
    }

    @Test
    public void test_lcm_0_0() {
	assertEquals(0, Rational.lcm(0,0));
    }

    @Test
    public void test_lcm_0_25() {
	assertEquals(25, Rational.gcd(0,25));
    }

    @Test
    public void test_lcm_20_0() {
	assertEquals(20, Rational.gcd(20,0));
    }

    @Test
    public void test_rational_7_3_plus_7_3(){
        Rational r = new Rational(7,3);
        Rational p = new Rational(7,3);
        assertEquals("14/3", r.plus(p).toString());
    }

    @Test
    public void test_rational_1_1_plus_7_3(){
        Rational r = new Rational(1,1);
        Rational p = new Rational(7,3);
        assertEquals("10/3", r.plus(p).toString());
    }

    @Test
    public void test_rational_n7_3_plus_7_3(){
        Rational r = new Rational(-7,3);
        Rational p = new Rational(7,3);
        assertEquals("0", r.plus(p).toString());
    }

    @Test
    public void test_rational_7_3_plus_1_n1(){
        Rational r = new Rational(7,3);
        Rational p = new Rational(1,-1);
        assertEquals("4/3", r.plus(p).toString());
    }

    @Test
    public void test_rational_7_3_plus_n14_3(){
        Rational r = new Rational(7,3);
        Rational p = new Rational(-14,3);
        assertEquals("-7/3", r.plus(p).toString());
    }

    @Test
    public void test_rational_7_3_plus_7_6(){
        Rational r = new Rational(7,3);
        Rational p = new Rational(10,6);
        assertEquals("4", r.plus(p).toString());
    }

    @Test
    public void test_rational_n3_1_plus_1_n3(){
        Rational r = new Rational(-3,1);
        Rational p = new Rational(1,-3);
        assertEquals("-10/3", r.plus(p).toString());
    }

    @Test
    public void test_rational_5_4_plus_3_4(){
        Rational r = new Rational(5,4);
        Rational p = new Rational(3,4);
        assertEquals("2", r.plus(p).toString());
    }


    @Test
    public void test_sum_r1_n3_1_r2_1_n3(){
        Rational r1 = new Rational(3,-1);
        Rational r2 = new Rational(1,-3);
        assertEquals("-10/3", Rational.sum(r1,r2).toString());
    }

    @Test
    public void test_sum_r1_5_4_r2_3_4(){
        Rational r1 = new Rational(5,4);
        Rational r2 = new Rational(3,4);
        assertEquals("2", Rational.sum(r1,r2).toString());
    }

    @Test
    public void test_sum_r1_7_3_r2_7_3() {
        Rational r1 = new Rational(7,3);
        Rational r2 = new Rational(7,3);
        assertEquals("14/3", Rational.sum(r1,r2).toString());
    }

    @Test
    public void test_sum_r1_7_3_r2_n7_3() {
        Rational r1 = new Rational(7,3);
        Rational r2 = new Rational(-7,3);
        assertEquals("0", Rational.sum(r1,r2).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_sum_r1_7_3_r2_0_0() {
        Rational r1 = new Rational(7,3);
        Rational r2 = new Rational(0,0);
    }

    @Test
    public void test_sum_5_15_3_r2_3_7() {
        Rational r1 = new Rational(5,15);
        Rational r2 = new Rational(3,7);
        assertEquals("16/21", Rational.sum(r1,r2).toString());
    }

    @Test
    public void test_r_3_7_minus_3_7() {
        Rational r1 = new Rational(3,7);
        Rational r2 = new Rational(3,7);
        assertEquals("0", r1.minus(r2).toString());
    }

    @Test
    public void test_r_3_7_minus_0_1() {
        Rational r1 = new Rational(3,7);
        Rational r2 = new Rational(0,1);
        assertEquals("3/7", r1.minus(r2).toString());
    }

    @Test
    public void test_r_3_7_minus_n3_7() {
        Rational r1 = new Rational(3,7);
        Rational r2 = new Rational(-3,7);
        assertEquals("6/7", r1.minus(r2).toString());
    }

    @Test
    public void test_r_n5_15_minus_3_7() {
        Rational r1 = new Rational(-5,15);
        Rational r2 = new Rational(3,7);
        assertEquals("-16/21", r1.minus(r2).toString());
    }

    @Test
    public void test_r_5_15_minus_n3_7() {
        Rational r1 = new Rational(5,15);
        Rational r2 = new Rational(-3,7);
        assertEquals("16/21", r1.minus(r2).toString());
    }

    @Test
    public void test_r_25_20_minus_13_4() {
        Rational r1 = new Rational(25,20);
        Rational r2 = new Rational(13,4);
        assertEquals("-2", r1.minus(r2).toString());
    }

    @Test
    public void test_difference_r1_25_20_r2_13_4() {
        Rational r1 = new Rational(25,20);
        Rational r2 = new Rational(13,4);
        assertEquals("-2", Rational.difference(r1,r2).toString());
    }

    @Test
    public void test_difference_r1_3_7_r2_3_7() {
        Rational r1 = new Rational(3,7);
        Rational r2 = new Rational(3,7);
        assertEquals("0", Rational.difference(r1,r2).toString());
    }

    @Test
    public void test_difference_r1_3_7_r2_0_1() {
        Rational r1 = new Rational(3,7);
        Rational r2 = new Rational(0,1);
        assertEquals("3/7", Rational.difference(r1,r2).toString());
    }

    @Test
    public void test_difference_r1_3_7_r2_n3_7() {
        Rational r1 = new Rational(3,7);
        Rational r2 = new Rational(-3,7);
        assertEquals("6/7", Rational.difference(r1,r2).toString());
    }

    @Test
    public void test_difference_r1_n5_15_r2_3_7() {
        Rational r1 = new Rational(-5,15);
        Rational r2 = new Rational(3,7);
        assertEquals("-16/21", Rational.difference(r1,r2).toString());
    }

    @Test
    public void test_difference_r1_5_15_r2_n3_7() {
        Rational r1 = new Rational(5,15);
        Rational r2 = new Rational(-3,7);
        assertEquals("16/21", Rational.difference(r1,r2).toString());
    }

    @Test
    public void test_rational_m10_m5() {
	Rational r = new Rational(-10,-5);
	assertEquals("2",r.toString());
    }

    @Test
    public void test_rational_m5_6() {
	Rational r = new Rational(-5,6);
	assertEquals("-5/6",r.toString());
    }

    @Test
    public void test_rational_7_m8() {
	Rational r = new Rational(7,-8);
	assertEquals("-7/8",r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
	Rational r = r_5_15.times(r_3_7);
	assertEquals("1/7",r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
	Rational r = r_3_7.times(r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = r_m3_1.times(r_1_m3);
	assertEquals("1",r.toString());
    }

   @Test
    public void test_product_of_r_5_15_and_r_3_7() {
       Rational r = Rational.product(r_5_15,r_3_7);
       assertEquals("1/7",r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
	Rational r = Rational.product(r_3_7,r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = Rational.product(r_m3_1,r_1_m3);
	assertEquals("1",r.toString());
    }

    @Test
    public void test_reciprocal_r_3_7() {
        Rational r = new Rational(3,7);
        assertEquals("7/3", r.reciprocalOf().toString());
    }

    @Test
    public void test_reciprocal_r_7_3() {
        Rational r = new Rational(7,3);
        assertEquals("3/7", r.reciprocalOf().toString());
    }

    @Test
    public void test_reciprocal_r_n3_7() {
        Rational r = new Rational(-3,7);
        assertEquals("-7/3", r.reciprocalOf().toString());
    }

    @Test
    public void test_reciprocal_r_3_n7() {
        Rational r = new Rational(3,-7);
        assertEquals("-7/3", r.reciprocalOf().toString());
    }

    @Test
    public void test_reciprocal_r_n3_n7() {
        Rational r = new Rational(-3,-7);
        assertEquals("7/3", r.reciprocalOf().toString());
    }

    @Test
    public void test_reciprocal_r_n13_4() {
        Rational r = new Rational(-13,4);
        assertEquals("-4/13", r.reciprocalOf().toString());
    }

    @Test(expected = ArithmeticException.class)
    public void test_reciprocal_r_0_1() {
        Rational r = new Rational(0,1);
        r.reciprocalOf();
    }

    @Test(expected = ArithmeticException.class)
    public void test_r_0_1_dividedBy_0() {
        Rational r1 = new Rational(0,1);
        Rational r2 = new Rational(0,1);
        r1.dividedBy(r2);
    }

    @Test
    public void test_r_0_1_dividedBy_1_1() {
        Rational r1 = new Rational(0,1);
        Rational r2 = new Rational(1,1);
        assertEquals("0", r1.dividedBy(r2).toString());
    }

    @Test
    public void test_r_1_1_dividedBy_1_5() {
        Rational r1 = new Rational(1,1);
        Rational r2 = new Rational(1,5);
        assertEquals("5", r1.dividedBy(r2).toString());
    }

    @Test
    public void test_r_1_1_dividedBy_5_1() {
        Rational r1 = new Rational(1,1);
        Rational r2 = new Rational(5,1);
        assertEquals("1/5", r1.dividedBy(r2).toString());
    }

    @Test
    public void test_r_1_1_dividedBy_n1_5() {
        Rational r1 = new Rational(1,1);
        Rational r2 = new Rational(-1,5);
        assertEquals("-5", r1.dividedBy(r2).toString());
    }

    @Test
    public void test_r_1_1_dividedBy_1_n5() {
        Rational r1 = new Rational(1,1);
        Rational r2 = new Rational(1,-5);
        assertEquals("-5", r1.dividedBy(r2).toString());
    }

    @Test
    public void test_r_1_1_dividedBy_n5_1() {
        Rational r1 = new Rational(1,1);
        Rational r2 = new Rational(-5,1);
        assertEquals("-1/5", r1.dividedBy(r2).toString());
    }

    @Test
    public void test_r_1_1_dividedBy_5_n1() {
        Rational r1 = new Rational(1,1);
        Rational r2 = new Rational(5,-1);
        assertEquals("-1/5", r1.dividedBy(r2).toString());
    }

    @Test
    public void test_r_3_5_dividedBy_4_3() {
        Rational r1 = new Rational(3,5);
        Rational r2 = new Rational(4,3);
        assertEquals("9/20", r1.dividedBy(r2).toString());
    }

    @Test
    public void test_quotient_r1_3_5_r2_4_3() {
        Rational r1 = new Rational(3,5);
        Rational r2 = new Rational(4,3);
        assertEquals("9/20", Rational.quotient(r1, r2).toString());
    }

    @Test
    public void test_quotient_r1_1_1_r2_1_5() {
        Rational r1 = new Rational(1,1);
        Rational r2 = new Rational(1,5);
        assertEquals("5", Rational.quotient(r1, r2).toString());
    }

    @Test
    public void test_quotient_r1_1_1_r2_1_n5() {
        Rational r1 = new Rational(1,1);
        Rational r2 = new Rational(1,-5);
        assertEquals("-5", Rational.quotient(r1, r2).toString());
    }

    @Test
    public void test_quotient_r1_1_1_r2_n1_5() {
        Rational r1 = new Rational(1,1);
        Rational r2 = new Rational(-1,5);
        assertEquals("-5", Rational.quotient(r1, r2).toString());
    }

    @Test
    public void test_quotient_r1_1_1_r2_5_1() {
        Rational r1 = new Rational(1,1);
        Rational r2 = new Rational(5,1);
        assertEquals("1/5", Rational.quotient(r1, r2).toString());
    }

    @Test
    public void test_quotient_r1_1_1_r2_n5_1() {
        Rational r1 = new Rational(1,1);
        Rational r2 = new Rational(-5,1);
        assertEquals("-1/5", Rational.quotient(r1, r2).toString());
    }

    @Test
    public void test_quotient_r1_1_1_r2_5_n1() {
        Rational r1 = new Rational(1,1);
        Rational r2 = new Rational(5,-1);
        assertEquals("-1/5", Rational.quotient(r1, r2).toString());
    }

    @Test
    public void test_quotient_r1_0_1_r2_5_n1() {
        Rational r1 = new Rational(0,1);
        Rational r2 = new Rational(5,-1);
        assertEquals("0", Rational.quotient(r1, r2).toString());
    }

    @Test(expected = ArithmeticException.class)
    public void test_quotient_r1_0_1_r2_0_1() {
        Rational r1 = new Rational(0,1);
        Rational r2 = new Rational(0,1);
        Rational.quotient(r1, r2);
    }
}
