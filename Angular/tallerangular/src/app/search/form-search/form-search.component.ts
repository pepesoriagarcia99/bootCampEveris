import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OwnerService } from '../owner.service';

@Component({
  selector: 'app-form-search',
  templateUrl: './form-search.component.html',
  styleUrls: ['./form-search.component.scss']
})
export class FormSearchComponent implements OnInit {

  public query: string;
  public result: string;
  @Input() labelButton: string;
  @Input() placeholder: string;
  @Output() searchEvent = new EventEmitter();
  owners;
  constructor(private ownerList: OwnerService) {
    this.query = '';
  }

  ngOnInit() {
    this.ownerList.getOwners().subscribe(resp => {
      this.owners = resp;
    });
  }
  search() {
    this.result = 'Consulta con query' + this.query;
    this.searchEvent.emit({ query: this.query, resultado: this.result });
  }

}
