# imgToGPDraw
## All java files are under [src]

1) Takes in png file and converts it to a NxM matrix of rgb values A

2) Runs A through method defined in the imgToGPDraw class to loop through A
   and moves the "pen" to the specified (x,y) cordinate and places a point with
   the RGB defined in A. This is almost representative of a real life printer where
   each line is printed one by one.

3) Time Complexity O(N^M)
