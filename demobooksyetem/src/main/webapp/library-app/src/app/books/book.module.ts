import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BooksComponent } from './books.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { BookResolver } from './book-resolver.service';
import { FormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";
import { BookEditComponent } from "./book-edit/book-edit.component";
import { BookEditInfoComponent }  from './book-edit/book-edit-info.component';

@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    RouterModule.forChild([
      {
        path: '',
        component: BooksComponent
      },
      {
        path: ':id',
        component: BookDetailsComponent,
        resolve: { resolvedData: BookResolver }
      },
      {
        path: ':id/edit',
        component: BookEditComponent,
        resolve: { resolvedData: BookResolver },
         children: [
          { path: '', redirectTo: 'info', pathMatch: 'full' },
          { path: 'info', component:BookEditInfoComponent }

        ]
      }
    ])

  ],
  declarations: [
    BooksComponent,
    BookDetailsComponent,
    BookEditComponent,
    BookEditInfoComponent
   ]
})
export class BookModule { }
