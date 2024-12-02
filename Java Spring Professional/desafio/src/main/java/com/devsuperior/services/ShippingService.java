package com.devsuperior.services;

import com.devsuperior.models.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double Shipment(Order order) {
        if (order.getBasic() < 100) {
            return 20;
        } else if(order.getBasic() >= 100 && order.getBasic() < 200) {
            return 12;
        } else {
            return 0;
        }
    }
}
