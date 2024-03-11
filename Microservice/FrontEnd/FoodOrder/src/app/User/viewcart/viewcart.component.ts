import { AfterViewInit, Component, ElementRef, OnChanges, OnInit, QueryList, SimpleChanges, ViewChild, ViewChildren } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/user.service';
import { CartIteam } from '../cart-iteam';


@Component({
  selector: 'app-viewcart',
  templateUrl: './viewcart.component.html',
  styleUrls: ['./viewcart.component.css']
})
export class ViewcartComponent implements  OnInit ,OnChanges,AfterViewInit  {




  quantity: number =1;
  userId!:number;
  cartIteam:CartIteam[]=[];
  cartEmpty:boolean=false;

constructor(private activaterouter:ActivatedRoute,private userservice:UserService,private router:Router)
{

}
  ngAfterViewInit(): void {
  }
  ngOnChanges(changes: SimpleChanges): void {
  
  }


ngOnInit(): void {
  this.activaterouter.params.subscribe(params => {
    this.userId= params['userId'];
  });
  this.userservice.getatcByUserId(this.userId).subscribe(
   (data)=>{this.cartIteam=data;
    if(this.cartIteam.length!=0)
    {
         this.cartEmpty=false;
    }
  
  
  },
   (error)=>{console.log("couldnt fetch");}


  );
  if(this.cartIteam.length==0)
  {
       this.cartEmpty=true;
  }





}

@ViewChild('quantity', { static: false }) q!:ElementRef;

@ViewChildren('iteamref') itemElements!: QueryList<ElementRef>;

increaseQuantity(id:number,quantity:number,c:any) {

  
this.userservice.increaseQuantity(id,quantity).subscribe(
(data)=>{this.quantity=data;
  // const paragraph = this.q.nativeElement;
  //   paragraph.textContent = data;
   
  c.quantity=data;
  // const targetElement = this.itemElements.find(el => el.nativeElement.innerText.includes(c.quantity));
  //     console.log(targetElement);
  //   if (targetElement) {
  //     // Modify the text content of the specific element
  //     targetElement.nativeElement.innerText= data;
  //   }

 
  },
(error)=>{console.log("couldnt fetch");}


);


}
decreaseQuantity(id:number,quantity:number,c:CartIteam) {


  if(quantity>1)
  {
  this.userservice.decreaseQuantity(id,quantity).subscribe(
    (data)=>{this.quantity=data;
      c.quantity=data;
      
    // const paragraph = this.q.nativeElement;
    //   paragraph.textContent = data;
  //   const targetElement = this.itemElements.find(el => el.nativeElement.innerText.includes(c.quantity));
  //   console.log(targetElement);
  // if (targetElement) {
  //   // Modify the text content of the specific element
  //   targetElement.nativeElement.innerText.includes = data;

  // }
    },
    (error)=>{console.log("couldnt fetch");}
    
    );
  }


}

data!:any;

delete(arg0: number,c:CartIteam) {
  
  this.userservice.deletecartbyId(arg0).subscribe(
   (data)=>{this.data=data;
    
    this.userservice.getatcByUserId(this.userId).subscribe(
      (data)=>{this.cartIteam=data;},
      (error)=>{console.log("couldnt fetch");}
   
   
     );
   
    
  },
   (error)=>{console.log("couldnt delete");}


  );



  }

  order() {
   
  
     this.router.navigate(['billingaddress',this.userId]);


    }

}
