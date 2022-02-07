package com.y4n9b0.fp

import kotlin.jvm.functions.FunctionN


fun <P1, P2, R> Function2<P1, P2, R>.curry() = fun(p1: P1) = fun(p2: P2) = this(p1, p2)

fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = this(p1, p2, p3)

fun <P1, P2, P3, P4, R> Function4<P1, P2, P3, P4, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = this(p1, p2, p3, p4)

fun <P1, P2, P3, P4, P5, R> Function5<P1, P2, P3, P4, P5, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = this(p1, p2, p3, p4, p5)

fun <P1, P2, P3, P4, P5, P6, R> Function6<P1, P2, P3, P4, P5, P6, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = this(p1, p2, p3, p4, p5, p6)

fun <P1, P2, P3, P4, P5, P6, P7, R> Function7<P1, P2, P3, P4, P5, P6, P7, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = this(p1, p2, p3, p4, p5, p6, p7)

fun <P1, P2, P3, P4, P5, P6, P7, P8, R> Function8<P1, P2, P3, P4, P5, P6, P7, P8, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = this(p1, p2, p3, p4, p5, p6, p7, p8)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, R> Function9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = fun(p9: P9) = this(p1, p2, p3, p4, p5, p6, p7, p8, p9)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> Function10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = fun(p9: P9) = fun(p10: P10) = this(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R> Function11<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = fun(p9: P9) = fun(p10: P10) = fun(p11: P11) = this(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R> Function12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = fun(p9: P9) = fun(p10: P10) = fun(p11: P11) = fun(p12: P12) = this(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, R> Function13<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = fun(p9: P9) = fun(p10: P10) = fun(p11: P11) = fun(p12: P12) = fun(p13: P13) = this(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, R> Function14<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = fun(p9: P9) = fun(p10: P10) = fun(p11: P11) = fun(p12: P12) = fun(p13: P13) = fun(p14: P14) = this(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, R> Function15<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = fun(p9: P9) = fun(p10: P10) = fun(p11: P11) = fun(p12: P12) = fun(p13: P13) = fun(p14: P14) = fun(p15: P15) = this(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, R> Function16<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = fun(p9: P9) = fun(p10: P10) = fun(p11: P11) = fun(p12: P12) = fun(p13: P13) = fun(p14: P14) = fun(p15: P15) = fun(p16: P16) = this(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, R> Function17<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = fun(p9: P9) = fun(p10: P10) = fun(p11: P11) = fun(p12: P12) = fun(p13: P13) = fun(p14: P14) = fun(p15: P15) = fun(p16: P16) = fun(p17: P17) = this(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, R> Function18<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = fun(p9: P9) = fun(p10: P10) = fun(p11: P11) = fun(p12: P12) = fun(p13: P13) = fun(p14: P14) = fun(p15: P15) = fun(p16: P16) = fun(p17: P17) = fun(p18: P18) = this(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, R> Function19<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = fun(p9: P9) = fun(p10: P10) = fun(p11: P11) = fun(p12: P12) = fun(p13: P13) = fun(p14: P14) = fun(p15: P15) = fun(p16: P16) = fun(p17: P17) = fun(p18: P18) = fun(p19: P19) = this(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, R> Function20<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = fun(p9: P9) = fun(p10: P10) = fun(p11: P11) = fun(p12: P12) = fun(p13: P13) = fun(p14: P14) = fun(p15: P15) = fun(p16: P16) = fun(p17: P17) = fun(p18: P18) = fun(p19: P19) = fun(p20: P20) = this(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, R> Function21<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = fun(p9: P9) = fun(p10: P10) = fun(p11: P11) = fun(p12: P12) = fun(p13: P13) = fun(p14: P14) = fun(p15: P15) = fun(p16: P16) = fun(p17: P17) = fun(p18: P18) = fun(p19: P19) = fun(p20: P20) = fun(p21: P21) = this(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, R> Function22<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, R>.curry() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = fun(p4: P4) = fun(p5: P5) = fun(p6: P6) = fun(p7: P7) = fun(p8: P8) = fun(p9: P9) = fun(p10: P10) = fun(p11: P11) = fun(p12: P12) = fun(p13: P13) = fun(p14: P14) = fun(p15: P15) = fun(p16: P16) = fun(p17: P17) = fun(p18: P18) = fun(p19: P19) = fun(p20: P20) = fun(p21: P21) = fun(p22: P22) = this(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22)


fun <P1, P2, R> ((P1) -> (P2) -> R).uncurry() = fun(p1: P1, p2: P2) = this(p1)(p2)

fun <P1, P2, P3, R> ((P1) -> (P2) -> (P3) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3) = this(p1)(p2)(p3)

fun <P1, P2, P3, P4, R> ((P1) -> (P2) -> (P3) -> (P4) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4) = this(p1)(p2)(p3)(p4)

fun <P1, P2, P3, P4, P5, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5) = this(p1)(p2)(p3)(p4)(p5)

fun <P1, P2, P3, P4, P5, P6, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6) = this(p1)(p2)(p3)(p4)(p5)(p6)

fun <P1, P2, P3, P4, P5, P6, P7, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)

fun <P1, P2, P3, P4, P5, P6, P7, P8, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> (P9) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)(p9)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> (P9) -> (P10) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)(p9)(p10)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> (P9) -> (P10) -> (P11) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)(p9)(p10)(p11)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> (P9) -> (P10) -> (P11) -> (P12) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)(p9)(p10)(p11)(p12)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> (P9) -> (P10) -> (P11) -> (P12) -> (P13) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12, p13: P13) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)(p9)(p10)(p11)(p12)(p13)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> (P9) -> (P10) -> (P11) -> (P12) -> (P13) -> (P14) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)(p9)(p10)(p11)(p12)(p13)(p14)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> (P9) -> (P10) -> (P11) -> (P12) -> (P13) -> (P14) -> (P15) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14, p15: P15) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)(p9)(p10)(p11)(p12)(p13)(p14)(p15)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> (P9) -> (P10) -> (P11) -> (P12) -> (P13) -> (P14) -> (P15) -> (P16) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14, p15: P15, p16: P16) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)(p9)(p10)(p11)(p12)(p13)(p14)(p15)(p16)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> (P9) -> (P10) -> (P11) -> (P12) -> (P13) -> (P14) -> (P15) -> (P16) -> (P17) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14, p15: P15, p16: P16, p17: P17) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)(p9)(p10)(p11)(p12)(p13)(p14)(p15)(p16)(p17)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> (P9) -> (P10) -> (P11) -> (P12) -> (P13) -> (P14) -> (P15) -> (P16) -> (P17) -> (P18) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14, p15: P15, p16: P16, p17: P17, p18: P18) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)(p9)(p10)(p11)(p12)(p13)(p14)(p15)(p16)(p17)(p18)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> (P9) -> (P10) -> (P11) -> (P12) -> (P13) -> (P14) -> (P15) -> (P16) -> (P17) -> (P18) -> (P19) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14, p15: P15, p16: P16, p17: P17, p18: P18, p19: P19) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)(p9)(p10)(p11)(p12)(p13)(p14)(p15)(p16)(p17)(p18)(p19)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> (P9) -> (P10) -> (P11) -> (P12) -> (P13) -> (P14) -> (P15) -> (P16) -> (P17) -> (P18) -> (P19) -> (P20) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14, p15: P15, p16: P16, p17: P17, p18: P18, p19: P19, p20: P20) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)(p9)(p10)(p11)(p12)(p13)(p14)(p15)(p16)(p17)(p18)(p19)(p20)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> (P9) -> (P10) -> (P11) -> (P12) -> (P13) -> (P14) -> (P15) -> (P16) -> (P17) -> (P18) -> (P19) -> (P20) -> (P21) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14, p15: P15, p16: P16, p17: P17, p18: P18, p19: P19, p20: P20, p21: P21) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)(p9)(p10)(p11)(p12)(p13)(p14)(p15)(p16)(p17)(p18)(p19)(p20)(p21)

fun <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, R> ((P1) -> (P2) -> (P3) -> (P4) -> (P5) -> (P6) -> (P7) -> (P8) -> (P9) -> (P10) -> (P11) -> (P12) -> (P13) -> (P14) -> (P15) -> (P16) -> (P17) -> (P18) -> (P19) -> (P20) -> (P21) -> (P22) -> R).uncurry() = fun(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14, p15: P15, p16: P16, p17: P17, p18: P18, p19: P19, p20: P20, p21: P21, p22: P22) = this(p1)(p2)(p3)(p4)(p5)(p6)(p7)(p8)(p9)(p10)(p11)(p12)(p13)(p14)(p15)(p16)(p17)(p18)(p19)(p20)(p21)(p22)


fun <R> FunctionN<R>.curry() {
    TODO("Let me think..")
}
