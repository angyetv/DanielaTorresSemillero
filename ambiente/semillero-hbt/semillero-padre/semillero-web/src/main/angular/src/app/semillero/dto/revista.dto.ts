/**
 * @description Clase RevistaDTO que contiene la informacion de una revista.
 * @author Angye Daniela Torres Veloza <angye.torres@uptc.edu.co>
 */
export class RevistaDTO {
    /**
     * Identificador de la revsta.
     */
    public id: number;

    /**
     * Nombre de la Revista.
     */
    public nombre: string;

    /**
     * Editorial de la Revista.
     */
    public editorial: string;

    /**
     * Temática de la revista.
     */
    public tematica: string;

    /**
     * Numero de paginas de la revista.
     */
    public numeroPaginas: number;

    /**
     * Precio de la revista.
     */
    public precio: number;

    /**
     * Autores de la revista.
     */
    public autores: string;

    /**
     * Color de tipo boolean
     */
    public aColor: boolean;

    /**
     * Fecha de venta de la revista.
     */
    public fechaVenta: Date;

    /**
     * Estado de la revista.
     */
    public estado: string;
}