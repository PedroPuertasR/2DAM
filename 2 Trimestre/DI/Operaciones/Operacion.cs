using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Operaciones
{
    public class Operacion
    {
        private int opr1;
        private int opr2;
        private char tipo_opr;

        /// <summary>
        /// Crea una instancia de operación para realizar un cálculo.
        /// </summary>
        /// <param name="opr1">Primer operando.</param>
        /// <param name="opr2">Segundo operando.</param>
        /// <param name="tipo_opr">Operación a ralizar: (+ --> Suma, - --> Resta, * --> Producto, / --> división entera, m --> media)</param>
        public Operacion(int opr1, int opr2, char tipo_opr)
        {
            this.opr1 = opr1;
            this.opr2 = opr2;
            this.tipo_opr = tipo_opr;
        }

        /// <summary>
        /// Ejecuta la operación en un tiempo inferior a 30 ms
        /// </summary>
        /// <returns>El resultado de la operación como un número entero (sin redondeo).</returns>
        /// <exception cref="ArgumentException">La operación indicada es desconocida o incorrecta.</exception>
        public int GetIntResult()
        {
            switch (tipo_opr)
            {
                case '+':
                    return opr1 + opr2;
                case '-':
                    return opr1 - opr2;
                case '*':
                    return opr1 * opr2;
                case '/':
                    return opr1 / opr2;
                case 'm':
                    return (opr1 + opr2) / 2;
                default:
                    throw new ArgumentException("Operación desconocida");
            }
        }

        /// <summary>
        /// Ejecuta la operación en un tiempo inferior a 60 ms
        /// </summary>
        /// <returns>El resultado de la operación como un número en punto flotante.</returns>
        /// <exception cref="ArgumentException">La operación indicada es desconocida o incorrecta.</exception>
        public double GetRealResult()
        {
            switch (tipo_opr)
            {
                case '+':
                    return (double)opr1 + opr2;
                case '-':
                    return (double)opr1 - opr2;
                case '*':
                    return (double)opr1 * opr2;
                case '/':
                    return (double)opr1 / opr2;
                case 'm':
                    return ((double)opr1 + opr2) / 2;
                default:
                    throw new ArgumentException("Operación desconocida");
            }
        }

        /// <summary>
        /// Crea un objeto diferente con los mismos datos del original
        /// </summary>
        /// <returns>Devuelve una copia del objeto pasado como parámetro.</returns>
        public Operacion Clone()
        {
            return new Operacion(this.opr1, this.opr2, this.tipo_opr);
        }

        public override bool Equals(Object? o)
        {
            if (o == null || this.GetType() != o.GetType())
                return false;

            Operacion operacion = (Operacion)o;
            return opr1 == operacion.opr1 && opr2 == operacion.opr2 && tipo_opr == operacion.tipo_opr;
        }

        public override int GetHashCode()
        {
            return Tuple.Create(opr1, opr2, tipo_opr).GetHashCode();
        }
    }
}
