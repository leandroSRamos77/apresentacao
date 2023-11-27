import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddTutorialComponent } from './components/add-tutorial/add-tutorial.component';
import { TutorialDetailsComponent } from './components/tutorial-details/tutorial-details.component';
import { TutorialsListComponent } from './components/tutorials-list/tutorials-list.component';
import { UserComponent } from './components/user/user.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { ChartLineComponent } from './components/chart-line/chart-line.component';
import { ChartBarComponent } from './components/chart-bar/chart-bar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTabsModule } from '@angular/material/tabs';
import { AcoesItauComponent } from './components/acoes-itau/acoes-itau.component';
import { AcoesPanComponent } from './components/acoes-pan/acoes-pan.component';
import { AcoesBovaComponent } from './components/acoes-bova/acoes-bova.component';
import { AcoesMagLuizaComponent } from './components/acoes-mag-luiza/acoes-mag-luiza.component';
import { AcoesViavarejoComponent } from './components/acoes-viavarejo/acoes-viavarejo.component';

@NgModule({
  declarations: [
    AppComponent,
    AddTutorialComponent,
    TutorialDetailsComponent,
    TutorialsListComponent,
    UserComponent,
    UserListComponent,
    AddUserComponent,
    ChartLineComponent,
    ChartBarComponent,
    AcoesItauComponent,
    AcoesPanComponent,
    AcoesBovaComponent,
    AcoesMagLuizaComponent,
    AcoesViavarejoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTabsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
