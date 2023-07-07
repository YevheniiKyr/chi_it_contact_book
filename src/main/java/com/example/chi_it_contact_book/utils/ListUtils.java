package com.example.chi_it_contact_book.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListUtils {
    public static boolean hasDuplicateElements(List<String> list) {
        Set<String> uniqueElements = new HashSet<>();

        for (String element : list) {
            if (uniqueElements.contains(element)) {
                return true;
            }
            uniqueElements.add(element);
        }

        return false;
    }

}
