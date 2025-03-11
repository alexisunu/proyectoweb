import { Routes } from '@angular/router';
import { LoginadminComponent } from './componentes/loginadmin/loginadmin.component';
import { BusquedaTipoComponent } from './componentes/vehiculo/busqueda-tipo/busqueda-tipo.component';
import { BusquedaPlacaComponent } from './componentes/alquiler/busqueda-placa/busqueda-placa.component';
import { BusquedaNumeroComponent } from './componentes/alquiler/busqueda-numero/busqueda-numero.component';
import { AdministradorComponent } from './componentes/administrador/administrador.component';

export const routes: Routes = [
    {path:"loginadmin", component: LoginadminComponent},
    {path:"vehiculosAdmin", component: BusquedaTipoComponent },
    {path:"AlquilerPlaca", component: BusquedaPlacaComponent },
    {path:"AlquilerNumero", component: BusquedaNumeroComponent},
    {path:"admin", component: AdministradorComponent}
];
