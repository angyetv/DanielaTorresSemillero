/**
 * @description Clase UsuarioDTO que contiene la informacion de un usuario
 *
 * @author Angye Daniela Torres <angye.torres@uptc.edu.co>
 */
export class UsuarioDTO {

    /**
    * Indicador de id.
    */
    public id: number;

    /**
    * Indicador de nombre.
    */
    public nombre: string;

    /**
    * Indicador de fechaCreacion.
    */
   public fechaCreacion: Date;

    /**
    * Indicador de estado.
    */
   public estado: String;

   /**
    * Indicador de resultado.
    */
   public idPersona: number;
}
