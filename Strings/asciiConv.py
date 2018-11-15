def decode(encoded):
    # Write your code here
    
    # reverse string
    encoded = encoded[::-1];
    result = ""

    i = 0
    while(i < len(encoded) - 1):

        currVal = encoded[i]
        nextVal = encoded[i+1]

        val = (int) (currVal + nextVal)

        if(val == 32):
            result += chr(val)
            i = i + 2

        #check if capital
        elif(val >= 65 and val <= 99):
            result += chr(val)
            i = i + 2

        else:
            thirdVal = encoded[i+2]
            val = (int) (currVal + nextVal + thirdVal)
            result += chr(val)
            i = i + 3


    return result