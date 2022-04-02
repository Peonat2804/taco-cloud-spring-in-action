package sia.tacocloud.messaging;

import sia.tacocloud.Order;

public interface OrderMessagingService {
    void sendOrder(Order order);
}
