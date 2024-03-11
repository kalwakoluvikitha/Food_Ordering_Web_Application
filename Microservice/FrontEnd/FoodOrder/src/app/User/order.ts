import { OrderItem } from "./order-item";

export class Order {



      orderId!:number;
	
	
	 orderStatus!:string;
	
	
	 payamentStatus!:String;
	
	 orderAmount!:number;
	
    billingAddress!:string;
	
	 userId!:number;
	
	
	 orderItems:OrderItem[]=[];
	
}
