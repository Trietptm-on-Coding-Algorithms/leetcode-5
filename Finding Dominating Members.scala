/**
 * Input:
 *    A: An integer seq containing at least one (A,k)-dominating element
 *    k: An integer >= 2
 * Output:
 *    An seq of (A,k)-dominating element(s) of A
 */
def FindDominatingNumbers(s: Seq[Int], k: Int):Seq[Int] = {
  require(k>=2 && s.length>=k)
  var cand = new Array[Int](k - 1)
  var cand_freq = new Array[Int](k - 1)
  s foreach (a => breakable {
    var i = -1;
    while (true) {
      i = i + 1
      if (i >= cand.length) {
        cand.indices foreach (i => cand_freq(i) = cand_freq(i) - 1)
        break
      }
      if (cand_freq(i) == 0) {
        cand(i) = a
        cand_freq(i) = 1
        break
      }
      if (cand(i) == a) {
        cand_freq(i) = cand_freq(i) + 1
        break
      }
    }
  })
  val threshold = cand_freq.sum / k
  (cand zip cand_freq).view.filter(_._2 > threshold).map(_._1).force
}