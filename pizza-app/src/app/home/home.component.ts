import { NgbCarouselConfig, NgbCarouselModule } from '@ng-bootstrap/ng-bootstrap';
import { ProductService } from '../services/product.service';
import { Product } from '../data-type';
import { CommonModule } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { NgbCarousel, NgbSlideEvent, NgbSlideEventSource } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NgbCarouselModule, CommonModule, FormsModule,RouterModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  paused = false;
	unpauseOnArrow = false;
	pauseOnIndicator = false;
	pauseOnHover = true;
	pauseOnFocus = true;

	@ViewChild('carousel', { static: true }) carousel!: NgbCarousel;

	togglePaused() {
		if (this.paused) {
			this.carousel.cycle();
		} else {
			this.carousel.pause();
		}
		this.paused = !this.paused;
	}

	onSlide(slideEvent: NgbSlideEvent) {
		if (
			this.unpauseOnArrow &&
			slideEvent.paused &&
			(slideEvent.source === NgbSlideEventSource.ARROW_LEFT || slideEvent.source === NgbSlideEventSource.ARROW_RIGHT)
		) {
			this.togglePaused();
		}
		if (this.pauseOnIndicator && !slideEvent.paused && slideEvent.source === NgbSlideEventSource.INDICATOR) {
			this.togglePaused();
		}
	}


  popularProducts:undefined|Product[];
  trendyProducts:undefined | Product[];
  constructor(config: NgbCarouselConfig, private product:ProductService) {
		// customize default values of carousels used by this component tree
		config.interval = 10000;
		config.wrap = false;
		config.keyboard = false;
		config.pauseOnHover = false;
	}
  
  ngOnInit(): void {
    this.product.popularProducts().subscribe((data)=>{
      console.log(data)
      this.popularProducts=data;
    })

    this.product.productList().subscribe((data)=>{
      this.trendyProducts=data;
    })
  } 
}
