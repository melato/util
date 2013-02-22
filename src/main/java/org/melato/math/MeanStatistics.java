package org.melato.math;

public class MeanStatistics {
  double  sx;
  double  sxx;
  int     n;
  public void add(float x) {
    sx += x;
    sxx += x * x;
    n++;
  }
  public int size() {
    return n;
  }
  public float mean() {
    return (float) (sx/n);
  }
  public float variance() {
    return (float) ((n*sxx-sx*sx)/(n*n));
  }
  public float standardDeviation() {
    return (float) Math.sqrt( variance() * n/(n-1));
  }
  public void mergeWith(MeanStatistics m) {
    sx += m.sx;
    sxx += m.sxx;
    n += m.n;
  }
}
