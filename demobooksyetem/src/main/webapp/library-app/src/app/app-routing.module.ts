import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { SelectiveStrategy } from './selective-strategy.service';

@NgModule({
  imports: [
    RouterModule.forRoot([
      {
        path: 'books',
        data: { preload: false },
        loadChildren: () =>
          import('./books/book.module').then(m => m.BookModule)
      }
    ], { enableTracing: true, preloadingStrategy: SelectiveStrategy })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
