package ua.skillsup.shop.services.converters;

import ua.skillsup.shop.services.dto.OrderDto;
import ua.skillsup.shop.web.dao.models.Order;

public interface OrderConverter {

    Order toEntity(OrderDto dto);
    OrderDto toDto(Order entity);
}
