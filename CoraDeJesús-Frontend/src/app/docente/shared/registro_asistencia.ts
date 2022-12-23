import { Estudiante } from "src/app/estudiante/shared/Estudiante.model"
import { Bimestre } from "./bimestre"
import { Estado } from "./estado"

export class RegistroAsistencia {
    idRegistro: number
    fecha:string
    estado: Estado
    estudiante: Estudiante
    bimestre: Bimestre
 }
 