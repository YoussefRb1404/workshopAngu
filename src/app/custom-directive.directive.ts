import { Directive, HostListener, HostBinding } from '@angular/core';

@Directive({
  selector: '[appCustomDirective]'
})
export class CustomDirectiveDirective {

  // Bind the backgroundColor style of the host element
  @HostBinding('style.backgroundColor') backgroundColor: string | null = null;

  constructor() { }

  // Mouse enters → change background color
  @HostListener('mouseenter') onMouseEnter() {
    this.backgroundColor = 'yellow'; // you can choose any color
  }

  // Mouse leaves → revert background color
  @HostListener('mouseleave') onMouseLeave() {
    this.backgroundColor = null;
  }
}