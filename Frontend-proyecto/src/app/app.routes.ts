import { BorraralquilerComponent } from './componentes/vehiculo/borraralquiler/borraralquiler.component';
import { Routes } from '@angular/router';
import { LoginadminComponent } from './componentes/loginadmin/loginadmin.component';
import { BusquedaTipoComponent } from './componentes/vehiculo/busqueda-tipo/busqueda-tipo.component';
import { BusquedaPlacaComponent } from './componentes/alquiler/busqueda-placa/busqueda-placa.component';
import { BusquedaNumeroComponent } from './componentes/alquiler/busqueda-numero/busqueda-numero.component';
import { AdministradorComponent } from './componentes/administrador/administrador.component';
import { AppComponent } from './app.component';
import { RegistroUsuarioComponent } from './componentes/registro-usuario/registro-usuario.component';
import { LoginUsuarioComponent } from './componentes/login-usuario/login-usuario.component';
import { UsuarioComponent } from './componentes/usuario/usuario.component';
import { InicioComponent } from './componentes/inicio/inicio.component';
import { BuscarTipoUsuarioComponent } from './componentes/vehiculo/buscar-tipo-usuario/buscar-tipo-usuario.component';
import { BusquedaEntregadosComponent } from './componentes/alquiler/busqueda-entregados/busqueda-entregados.component';

export const routes: Routes = [
    {path:"loginadmin", component: LoginadminComponent},
    {path:"vehiculosAdmin", component: BusquedaTipoComponent },
    {path:"vehiculoUsuario", component:BuscarTipoUsuarioComponent},
    {path:"AlquilerPlaca", component: BusquedaPlacaComponent },
    {path:"AlquilerNumero", component: BusquedaNumeroComponent},
    {path:"admin", component: AdministradorComponent},
    {path:"registrousuario", component:RegistroUsuarioComponent},
    {path:"loginusuario", component:LoginUsuarioComponent},
    {path:"usuario", component:UsuarioComponent},
    {path:"", component:InicioComponent},
    {path:"borraralquiler", component: BorraralquilerComponent},
    {path:"buscaralquiler", component:BusquedaEntregadosComponent}
];
