public class Fraccion extends Numero {

  public Fraccion( int aNumerator, int aDenominator ) {
    if (aNumerator == 0) {
        throw new IllegalArgumentException( "Una fraccion no puede ser cero" );
    }
    if (aDenominator == 1) {
        throw new IllegalArgumentException( "Una fraccion no puede tener denominador 1 porque sino es un entero" );
    }
    type = Fraccion;
    numerator = aNumerator;
    denominator = aDenominator;
  }

  @Override
  public Numero substractedBy(Numero aSubstractor){
    return aSubstractor.substractedByAFraccion(this);
  }

  public Numero multipliedBy(Numero aMultiplier ) {
    return aMultiplier.multiplicarAFraccion( this );
  }    
  
  public Numero multiplicarAEntero( Entero anEnteroMultiplier ) {
    return with( numerator * anEnteroMultiplier.value, denominator );
  }

  public Numero multiplicarAFraccion( Fraccion aFraccionMultiplier ) {
    return with( numerator * aFraccionMultiplier.numerator,
        denominator * aFraccionMultiplier.denominator );
  }

  @Override
  public Numero addedTo(Numero anAdder) {
    return anAdder.addedToAFraction(this);
  }

  @Override
  public Numero dividedBy(Numero aDivisor) {
    return aDivisor.dividedByAFraccion(this);
  }

  @Override
  protected Numero addedToAnEntero(Entero entero) {
    return with(this.numerator + this.denominator * entero.value, this.denominator);
  }

  @Override
  protected Numero addedToAFraction(Fraccion fraccion) {
    return with(this.numerator * fraccion.denominator + this.denominator * fraccion.numerator, this.denominator * fraccion.denominator);
  }

  @Override
  protected Numero divideByAnEntero(Entero entero) {
    return with(this.denominator * entero.value, this.numerator);
  }

  @Override
  protected Numero dividedByAFraccion(Fraccion fraccion) {
    return with(this.denominator * fraccion.numerator, this.numerator * fraccion.denominator);
  }

  @Override
  protected Numero substractedByAnEntero(Entero entero) {
    return with(this.denominator * entero.value - this.numerator, this.denominator);
  }

  @Override
  protected Numero substractedByAFraccion(Fraccion fraccion) {
    return with(fraccion.numerator*this.denominator - this.numerator*fraccion.denominator, this.denominator * fraccion.denominator);
  }


}
