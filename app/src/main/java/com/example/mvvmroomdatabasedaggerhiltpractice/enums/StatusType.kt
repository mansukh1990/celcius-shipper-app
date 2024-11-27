package com.example.mvvmroomdatabasedaggerhiltpractice.enums

enum class StatusType(val id: String, val type: String) {
    Placed("1", "Placed"),
    Arrived("2", "Arrived"),
    Unloading_Completed("4", "Unloading Completed"),
    QC_Completed("6", "QC Completed"),
    Put_Away_Completed("8", "Put Away Completed"),
    PICKING("9", "Picking"),
    PICKINGCOMPLETED("10", "Picking Completed"),
    MANIFEST("11", "Manifest"),
    COMPLETED("13", "Completed"),
    RETURNORDER("14", "Return Order"),
    RETURNCOMPLETED("15", "Return Completed"),

}