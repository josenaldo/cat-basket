package br.com.josenaldo.catbasket.infrastructure.controllers.util;

import br.com.josenaldo.catbasket.domain.application.SortDirection;
import br.com.josenaldo.catbasket.domain.application.SortRequest;

import java.util.ArrayList;
import java.util.List;

public class SortParameterParser {

    public List<SortRequest> parseSortParameter(String sortParameter, List<String> possibleFieldNames)  {
        List<SortRequest> sortRequests = new ArrayList<>();

        if (sortParameter != null && !sortParameter.isEmpty()) {
            String[] sortFields = sortParameter.split("\\|");

            for (String sortField : sortFields) {
                String[] parts = sortField.split(",");

                if (parts.length == 2) {
                    String field = parts[0];
                    String direction = parts[1].toUpperCase();

                    if (isValidSortField(field, possibleFieldNames) && isValidSortDirection(direction)) {
                        SortRequest sortRequest = new SortRequest(field, SortDirection.valueOf(direction));
                        sortRequests.add(sortRequest);
                    }
                }
            }
        }

        return sortRequests;
    }

    private boolean isValidSortDirection(String direction) {
        try{
            SortDirection.valueOf(direction);
        }catch (IllegalArgumentException | NullPointerException exception) {
            return false;
        }

        return true;
    }

    private boolean isValidSortField(String field, List<String> possibleFieldNames) {
        return possibleFieldNames.contains(field);
    }
}
