# Bazier-Curve-Illustration
A java program that illustrates the working of Bazier Curves using mouse clicks and drawing the curve using the point of click
The illustration works for first 5 points.
Each time user clicks on the screen, thrugh MouseListener, the point of the click is saved.
The line/curve between the points is drawn by drawing multiple Ovals using Graphics2D.fillOval method.
The location where these Ovals are to be drawn is derived using the Bazier Curve equations
