import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']   // ✅ doit être styleUrls
})
export class HomeComponent {
  isDarkMode = false;

  MyCollection = ["TWIN1", "4TWIN2", "4TWIN3", "TWIN4"]; // ✅ doit être défini dans la classe, pas dans la méthode

  toggleTheme() {
    this.isDarkMode = !this.isDarkMode;
  }
}
