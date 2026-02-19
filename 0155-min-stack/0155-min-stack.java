class MinStack 
{
    Stack< Integer > stack;
    Stack< Integer > minRefStack;
    
    public MinStack() 
    {
        stack = new Stack< Integer >();
        minRefStack = new Stack< Integer >();    
    }
    
    public void push(int val) 
    {
        stack.push( val );
        if( minRefStack.isEmpty() )
        {
            minRefStack.push( val );
        }
        else
        {
            if( minRefStack.peek() < val )
                minRefStack.push( minRefStack.peek() );
            else
                minRefStack.push( val );
        }
    }
    
    public void pop() 
    {
        if( !stack.isEmpty() )
        {
            stack.pop();
            minRefStack.pop();
        } 
    }
    
    public int top() 
    {
        return stack.peek();    
    }
    
    public int getMin() 
    {
        if( !minRefStack.isEmpty() )
            return minRefStack.peek();
        else
            return -1;    
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */