import { Usuario } from "../usuario/usuario";

export class Alquiler {
    idAlquiler:number;
    identificacion:Usuario;
    idAdmin:number;
    valorAlquiler:number;
    estado:String;
    fechaInicio:Date;
    fechaEntrega:Date;

}
