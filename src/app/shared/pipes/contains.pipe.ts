import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'contains' })
export class ContainsPipe implements PipeTransform {
  transform(items: any[], searchText: string): any[] {
    if (!items) return [];
    if (!searchText) return items;

    const q = searchText.toLowerCase();
    return items.filter(item =>
      JSON.stringify(item).toLowerCase().includes(q)
    );
  }
}
