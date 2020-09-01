#include<stdio.h>
#include<dos.h>
#include<conio.h>
#include<graphics.h>
void main (){

	int gm, gd, i;
	gm=gd=DETECT;
	initgraph(&gd, &gm, "C:\\TC\\BGI");


	ellipse(235, 247, 130, 428, 100, 90); // Tummy
	ellipse(240, 320, 0, 360, 4, 4); // Tummy point


	ellipse(170, 330, 105, 358, 100, 50); // Left Leg
	ellipse(343, 330, 195, 100, 80, 50); // Right Leg

	setfillstyle(3, 15);
	floodfill(170, 330, 15);

	setfillstyle(3, 15);
	floodfill(343, 330, 15);

	ellipse(245, 147, 50, 140, 40, 51); // Right Head
	ellipse(186, 150, 45, 140, 40, 51); // Left Head


	arc(230, 138, 290, 410, 50); // Right chick
	arc(200, 140, 150, 250, 50); // Left chick

	ellipse(135, 150, 45, 140, 40, 51); // Left Ear
	arc(150, 133, 155, 295, 49);

	ellipse(305, 145, 50, 140, 40, 51); // Right Ear
	arc(270, 120, 295, 380, 60);

	// Trunk
	ellipse(185, 180, 550, 290, 0, 10);
	ellipse(225, 200, 170, 280, 40, 30);
	ellipse(250, 180, 550, 290, 0, 10);
	ellipse(285, 173, 200, 280, 40, 30);
	ellipse(260, 229, 0, 360, 40, 1);
	ellipse(270, 277, 9, 100, 80, 50);
	ellipse(270, 250, 6, 90, 80, 50);


	// Eyes
	ellipse(200, 150, 0, 70, 10, 10);
	ellipse(240, 150, 98, 180, 10, 10);


	for(i=0; i<30; i++){
		setcolor(i);
		ellipse(235, 247, 130, 428, 100, 90); // Tummy
		ellipse(240, 320, 0, 360, 4, 4); // Tummy point

		ellipse(170, 330, 105, 358, 100, 50); // Left Leg
		ellipse(343, 330, 195, 100, 80, 50); // Right Leg

		// Left Leg Fill
		setfillstyle(3, i);
		floodfill(170, 330, i);

		// Right Leg Fill
		setfillstyle(3, i);
		floodfill(343, 330, i);


		ellipse(245, 147, 50, 140, 40, 51); // Right Head
		ellipse(186, 150, 45, 140, 40, 51); // Left Head


		arc(230, 138, 290, 410, 50); // Right chick
		arc(200, 140, 150, 250, 50); // Left chick

		ellipse(135, 150, 45, 140, 40, 51); // Left Ear
		arc(150, 133, 155, 295, 49);

		ellipse(305, 145, 50, 140, 40, 51); // Right Ear
		arc(270, 120, 295, 380, 60);


		// Trunk
		setcolor(i+1);
		ellipse(185, 180, 550, 290, 0, 10);
		ellipse(225, 200, 170, 280, 40, 30);
		ellipse(250, 180, 550, 290, 0, 10);
		ellipse(285, 173, 200, 280, 40, 30);
		ellipse(260, 229, 0, 360, 40, 1);
		ellipse(270, 277, 9, 100, 80, 50);
		ellipse(270, 250, 6, 90, 80, 50);


		// Eyes
		ellipse(200, 150, 0, 70, 10, 10);
		ellipse(240, 150, 98, 180, 10, 10);
		delay(400);

	}
	getch();
	closegraph();
}