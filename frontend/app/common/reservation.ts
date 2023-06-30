import { Order } from "./order";
import { User } from "./user";

export class Reservation {

    constructor(private order: Order, private user: User) {}
}
