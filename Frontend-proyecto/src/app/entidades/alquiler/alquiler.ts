import { Usuario } from "../usuario/usuario";
import { Vehiculo } from "../vehiculo/vehiculo";

export class Alquiler {
    idAlquiler:number;
    identificacion:Usuario;
    idAdmin:number;
    idVehiculo:Vehiculo;
    valorAlquiler:number;
    estado:String;
    fechaInicio:Date;
    fechaEntrega:Date;

}
