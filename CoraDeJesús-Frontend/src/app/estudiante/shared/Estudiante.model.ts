import { Rol } from "src/app/docente/shared/rol";

export class Estudiante {
    "idUsuario": number;
    "dni": string;
    "nombre": string;
    "apellidoPaterno":string;
    "apellidoMaterno":string;
    "sexo": string;
    "clave": string;
    "rol": Rol
    "direccion": string;
    "correo": string;
    "telefono": string;
    "nombreApoderado": string;
    "ver": boolean
}