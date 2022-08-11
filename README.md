# 2D Isometric Graphics

## Overview

This is a fun and simple way to create isometric graphics in a 2D renderer. I made this with AWT and Swing.

## Maths

### Calculations

To get the `i` and `j` positions (The positions relative to `x` and `y`) there is a simple bit of maths involved to calculate the new positions for the images.
`l` (`y`) isn't a real dimension in the rendering, I implemented it to work with layers. The `l` / `y` is just the same as the regular screen dimensions.

For Example:
```
TILESIZE = 32

x = 10
y = 3
z = 8

(float) new_x_i = x * 0.5 * TILESIZE (160)
(float) new_z_i = z * -0.5 * TILESIZE (128)
(int) i = new_x_i + new_z_i (288)
Round i to 0dp (whole number) - This is to make sure that there are no errors where you try and draw the image at a float value

(float) new_x_j = x * 0.25 * TILESIZE (80)
(float) new_z_j = z * 0.25 * TILESIZE (64)
(int) j = new_x_j + new_z_j (144)
Round j to 0dp (whole number)

(int) l = j - (y * (TILESIZE / 2)) (96)
```

### Rendering

Draw image at `i, l` (`x, y`)

![Image](https://github.com/404-WasFound/2d-isometric-graphics/blob/main/screenshot.jpg)
