package vending.setup;

import vending.chain.SnackDispenseHandler;
import vending.chain.CheetosHandler;
import vending.chain.CokeHandler;
import vending.chain.DoritosHandler;
import vending.chain.KitKatHandler;
import vending.chain.PepsiHandler;
import vending.chain.SnickersHandler;

public class HandlerChainBuilder {
    public static SnackDispenseHandler buildDefaultChain() {
        SnackDispenseHandler head = new CokeHandler();
        head
            .setNext(new PepsiHandler())
            .setNext(new CheetosHandler())
            .setNext(new DoritosHandler())
            .setNext(new KitKatHandler())
            .setNext(new SnickersHandler());
        return head;
    }
}

