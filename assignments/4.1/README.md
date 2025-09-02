<p>This project is about a calculator with following function:</p>
<ol>
<li>Resets the calculator to zero.</li>
<li>Adds a number to the current value.</li>
<li>Returns the current value of the calculator.</li>
</ol>
<code>
class Calculator:<br />
    class Calculator{<br />
    double sum = 0;<br />
    public void reset(){<br />
        sum = 0;<br />
    }<br />
    public void add(double num){<br />
        if(num > 0){sum += num;}<br />
        else{throw new IllegalArgumentException("Negative numbers are not allowed: " + num);}<br />
    }<br />
    public double getSum(){<br />
        return sum;<br />
    }<br />
</code>
<h5>How it works</h5>
<p>
The calculator starts with a value of zero. You can add positive numbers to the current value using the add method. If you try to add a negative number, the calculator will throw an exception to prevent invalid operations. You can reset the calculator to zero at any time with the reset method, and use the getSum method to retrieve the current value.
</p>