import { Directive, ElementRef, Renderer2, HostListener } from '@angular/core';

@Directive({
  selector: '[appHighlight]' // utilisation: <div appHighlight>...</div>
})
export class HighlightDirective {
  private readonly cls = 'highlight';

  constructor(private el: ElementRef, private renderer: Renderer2) {}

  @HostListener('mouseenter')
  onEnter(): void {
    this.renderer.addClass(this.el.nativeElement, this.cls);
  }

  @HostListener('mouseleave')
  onLeave(): void {
    this.renderer.removeClass(this.el.nativeElement, this.cls);
  }
}
