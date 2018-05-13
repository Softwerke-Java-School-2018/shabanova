package ru.softwerke.controller.sort;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by DS on 07.05.2018.
 */
public class Sort {
    Comparator<LocalDate> comparator = new Comparator<LocalDate>() {
        @Override
        public int compare(LocalDate o1, LocalDate o2) {
            return o1.compareTo(o2);
             }
    };
}



