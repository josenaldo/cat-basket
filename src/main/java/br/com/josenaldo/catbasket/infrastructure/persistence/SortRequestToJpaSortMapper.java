package br.com.josenaldo.catbasket.infrastructure.persistence;

import br.com.josenaldo.catbasket.application.SortDirection;
import br.com.josenaldo.catbasket.application.SortRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public class SortRequestToJpaSortMapper {
    public Sort mapToJpaSort(List<SortRequest> sortRequestList) {
        if (sortRequestList == null || sortRequestList.isEmpty() ) {
            return Sort.unsorted();
        }

        List<Sort.Order> orders = sortRequestList.stream().map(sortRequest -> {
            if (sortRequest.direction() == SortDirection.ASC) {
                return Sort.Order.asc(sortRequest.field());
            }
            return  Sort.Order.desc(sortRequest.field());
        }).toList();


        return Sort.by(orders);
    }
}
