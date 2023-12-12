public class Entero extends Numero {

  public Entero( int aValue ) {
    type = Entero;
    value = aValue;
  }

  @Override
  public Numero substractedBy(Numero aSubtractor) {
    return aSubtractor.substractedByAnEntero(this);
  }

  public Numero multipliedBy(Numero aMultiplier ) {
    return aMultiplier.multiplicarAEntero( this );
    
//    if( aMultiplier.type == Entero) {
//      return multiplicarAEntero( aMultiplier );
//    } else {  //fraccion
//      return multiplicarAFraccion( aMultiplier );
//    }
  }

  public Numero multiplicarAEntero( Entero anEnteroMultiplier ) {
    return new Entero( value * anEnteroMultiplier.value );
  }

  public Numero multiplicarAFraccion( Fraccion aFraccionMultiplier ) {
    return with( value * aFraccionMultiplier.numerator, aFraccionMultiplier.denominator );
  }

  @Override
  public Numero addedTo(Numero anAdder) {
    return anAdder.addedToAnEntero(this);
  }

  @Override
  protected Numero addedToAnEntero(Entero entero) {
    return new Entero(this.value + entero.value);
  }

  @Override
  protected Numero addedToAFraction(Fraccion fraccion) {
    return new Fraccion(this.value * fraccion.denominator + fraccion.numerator, fraccion.denominator);
  }
  @Override
  protected Numero divideByAnEntero(Entero entero) {
//    if (greatestCommonDivisor(this.value, entero.value) != 1) {
//      return with(entero.value / this.value);
//    }
    return with(entero.value,this.value);
  }
  @Override
  protected Numero dividedByAFraccion(Fraccion fraccion) {
    return with(fraccion.numerator, fraccion.denominator * this.value);
  }

  @Override
  protected Numero substractedByAnEntero(Entero entero) {
    return new Entero(entero.value - this.value);
  }

  @Override
  protected Numero substractedByAFraccion(Fraccion fraccion) {
    return new Fraccion(fraccion.numerator - this.value * fraccion.denominator, fraccion.denominator);
  }

  @Override
  public Numero dividedBy(Numero aDivisor) {
    if (this.value == 0){
      throw new RuntimeException( CanNotDivideByZero );
    }
    return aDivisor.divideByAnEntero(this);
  }

}
