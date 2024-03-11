import { Food } from "./food";

export class Restaurant {

    restId!:number;
	
	restName!:string;
	
	location!:string;

	rating!:number ;

	image!:string;
	
	food:Food[]=[];


}



