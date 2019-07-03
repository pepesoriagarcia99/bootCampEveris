import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  labelBuscar: string;
  placeholder: string;
  msgEventSearch: string;
  constructor() {
    this.labelBuscar = 'Botón';
    this.placeholder = 'Esto es una prueba';
  }

  search(event) {
    this.msgEventSearch = event.query + '=> ' + event.resultado;
  }
}
