package scripts;

import java.awt.Color;

import org.tribot.api2007.Login;
import org.tribot.api2007.Login.STATE;
import org.tribot.api2007.Players;
import org.tribot.api2007.WorldHopper;
import org.tribot.script.ScriptManifest;
import org.tribot.script.sdk.Chatbox;
import org.tribot.script.sdk.MyPlayer;
import org.tribot.script.sdk.Quest;
import org.tribot.script.sdk.Waiting;
import org.tribot.script.sdk.painting.Painting;
import org.tribot.script.sdk.query.Query;
import org.tribot.script.sdk.script.TribotScript;
import org.tribot.script.sdk.types.WorldTile;

import scripts.handler.MyChat;
import scripts.handler.Tools2;

@ScriptManifest(authors = { "bill" }, category = "bill", name = "Task_Ernest_The_Chicken")
public class Task_Ernest_The_Chicken implements TribotScript {

	private static final String Verson = "1.0";

	public Quest task = Quest.ERNEST_THE_CHICKEN;
	
	private boolean[] taskList = { false, false, false, false, false, false, false, false, false, false, false, false,
			false };

	@Override
	public void execute(String arg0) {

		Painting.addPaint(g -> {
			g.setColor(Tools2.backColor);
			g.fillRoundRect(0, 340, 520, 140, 10, 10);
			g.setColor(Color.black);
			g.drawRoundRect(0, 340, 520, 140, 10, 10);
			g.setColor(Color.WHITE);
			g.setFont(Tools2.f);
			g.drawString("[" + Verson + "]Task_Ernest_The_Chicken", 8, 340 + 1 * 30);
			g.drawString("[" + WorldHopper.getWorld() + "]<World", 6, 340 + 2 * 30);
			g.drawString("[" + Tools2.getTime(Tools2.startTime) + "]RuneTime", 6, 340 + 3 * 30);
		});

		Tools2.startTime = System.currentTimeMillis();
		Tools2.init();
		Tools2.isLoop = true;
		while (Tools2.isLoop) {
			Waiting.wait(100);
			if (Tools2.readBook()) {
			} else if (Login.getLoginState() == STATE.INGAME) {
				if (task.getStep() == 0) {// ╫схннЯ
					if (Tools2.inBox(3106, 3333, 3114, 3326)) {
						MyChat.talkNpc(3561, 1, 0);
					} else {
						Tools2.walkto(3110, 3329);
					}
				} else if (task.getStep() == 1) {//
					if (Tools2.inBox(3104, 3370, 3112, 3362, 2)) {
						MyChat.talkNpc(3562, "Ernest", "Change him back this");
					} else {
						Tools2.walkto(3108, 3368, 2);
					}
				} else if (task.getStep() == 2) {//
					if (Tools2.invIsHave(277)) {
						if (Tools2.inBox(3090, 9757, 3099, 9753)) {
							Tools2.objectClickWalkTo("Open", 141);
						} else if (Tools2.inBox(3100, 9757, 3118, 9745)) {
							Tools2.objectClickWalkTo("Climb-up", 132);
						} else if (Tools2.inBox(3108, 3370, 3112, 3362, 2)) {
							MyChat.talkNpc(3562, "Ernest", "Change him back this");
						} else {
							Tools2.walkto(3108, 3368, 2);
						}
					} else if (Tools2.invIsHave(276)) {
						if (Tools2.inBox(3108, 3368, 3112, 3366)) {
							Tools2.objectClick(131, "Open");
							Waiting.waitNormal(1350, 150);
						} else if (Tools2.inBox(3088, 9768, 3118, 9745)) {
							if (taskList[8]) {
								if (Tools2.inBox(3090, 9757, 3099, 9753)) {
									Tools2.groundItemClick(277, "Take");
									Waiting.waitNormal(1350, 150);
								} else if (Tools2.inBox(3100, 9757, 3118, 9745)) {
									Tools2.objectClickWalkTo("Open", 141);
								} else if (Tools2.inBox(3100, 9762, 3104, 9758)) {
									Tools2.objectClickWalkTo("Open", 145);
								} else if (Tools2.inBox(3100, 9767, 3104, 9763)) {
									Tools2.objectClickWalkTo("Open", 142);
								} else {
									Tools2.objectClickWalkTo("Open", 138);
								}
							} else if (taskList[7]) {
								if (Tools2.inBox(3105, 9767, 3112, 9758)) {
									Tools2.objectClickWalkTo("Open", 137);
								} else if (Tools2.inBox(3100, 9767, 3104, 9763)) {
									Tools2.objectClickWalkTo("Open", 138);
								} else {
									taskList[8] = pull(150, "up");
								}
							} else if (taskList[6]) {
								if (Tools2.inBox(3105, 9767, 3112, 9758)) {
									taskList[7] = pull(148, "down");
								} else if (Tools2.inBox(3100, 9767, 3104, 9763)) {
									Tools2.objectClickWalkTo("Open", 137);
								} else {
									Tools2.objectClickWalkTo("Open", 138);
								}
							} else if (taskList[5]) {
								taskList[6] = pull(150, "down");
							} else if (taskList[4]) {
								if (Tools2.inBox(3100, 9757, 3118, 9745)) {
									Tools2.objectClickWalkTo("Open", 145);
								} else if (Tools2.inBox(3100, 9762, 3104, 9758)) {
									Tools2.objectClickWalkTo("Open", 140);
								} else if (Tools2.inBox(3095, 9762, 3099, 9758)) {
									Tools2.objectClickWalkTo("Open", 143);
								} else {
									taskList[5] = pull(151, "down");
								}
							} else if (taskList[3]) {
								taskList[4] = pull(146, "up");
							} else if (taskList[2]) {
								if (Tools2.inBox(3100, 9757, 3118, 9745)) {
									taskList[3] = pull(147, "up");
								} else if (Tools2.inBox(3100, 9762, 3104, 9758)) {
									Tools2.objectClickWalkTo("Open", 145);
								} else {
									Tools2.objectClickWalkTo("Open", 139);
								}
							} else if (taskList[1]) {
								if (Tools2.inBox(3105, 9767, 3112, 9758)) {
									taskList[2] = pull(149, "down");
								} else {
									Tools2.objectClickWalkTo("Open", 144);
								}
							} else if (taskList[0]) {
								taskList[1] = pull(146, "down");
							} else {
								taskList[0] = pull(147, "down");
							}
						} else {
							Tools2.walkto(3117, 9753);
						}
					} else if (Tools2.invIsHave(271)) {
						if (Tools2.inBox(3105, 3368, 3112, 3366)) {
							if (Players.getAll().length <= 1) {
								if (Tools2.inBox(3108, 3368, 3112, 3366)) {
									Tools2.groundItemClick(276, "Take");
									Waiting.waitNormal(1350, 150);
								} else {
									Tools2.walkto(3110, 3367);
								}
							} else {
								WorldHopper.changeWorld(WorldHopper.getRandomWorld(MyPlayer.isMember(), false));
							}
						} else {
							Tools2.walkto(3106, 3367);
						}
					} else if (Tools2.invIsHave(275)) {
						MyChat.clickContinue();
						if (Tools2.inBox(3084, 3338, 3091, 3331)) {
							if (Tools2.invIsHave(274)) {
								Tools2.invUseToObject(153, 274);
								Waiting.waitNormal(1350, 150);
							} else if (MyChat.isOpenChat()) {
								MyChat.clickContinue();
							} else {
								Tools2.objectClick(153, "Search");
								Waiting.waitNormal(1350, 150);
							}
						} else {
							Tools2.walkto(3089, 3335);
						}
					} else if (Tools2.invIsHave(952)) {
						if (Tools2.inBox(3084, 3370, 3090, 3351)) {
							Tools2.objectClick(152, "Search");
							Waiting.waitNormal(1350, 150);
						} else {
							Tools2.walkto(3086, 3360);
						}
					} else if (Tools2.invIsHave(274)) {
						if (Tools2.inBox(3120, 3360, 3126, 3354, 0)) {
							Tools2.groundItemClick(952, "Take");
						} else {
							Tools2.walkto(3121, 3357, 0);
						}
					} else if (Tools2.invIsHave(273)) {
						Tools2.invUseToItem(272, 273);
						Waiting.waitNormal(2350, 150);
					} else if (Tools2.invIsHave(272)) {
						if (Tools2.inBox(3097, 3366, 3101, 3364, 0)) {
							Tools2.groundItemClick(273, "Take");
						} else {
							Tools2.walkto(3098, 3365, 0);
						}
					} else if (Tools2.inBox(3107, 3361, 3110, 3354, 1)) {
						Tools2.groundItemClick(272, "Take");
					} else {
						Tools2.walkto(3107, 3357, 1);
					}
				} else if (task.getStep() == 30) {//
					if (Tools2.inBox(3252, 3488, 3259, 3471)) {
						MyChat.talkNpc(5038, 1, 0);
					} else {
						Tools2.walkto(3252, 3481);
					}
				} else if (task.getStep() == 40) {//
					if (Tools2.inBox(3192, 3406, 3198, 3402)) {
						MyChat.talkNpc(5036, "Talk about something", "Talk about Romeo");
					} else {
						Tools2.walkto(3197, 3403);
					}
				} else if (task.getStep() == 50) {//
					if (!Tools2.invIsHave(756)) {
						if (Tools2.inBox(3192, 3406, 3198, 3402)) {
							MyChat.talkNpc(5036, "Talk about something", "Talk about Romeo");
						} else {
							Tools2.walkto(3197, 3403);
						}
					} else if (Tools2.inBox(3155, 3426, 3161, 3425, 1)) {
						MyChat.talkNpc(6268, 1, 0);
					} else {
						Tools2.walkto(3157, 3425, 1);
					}
				} else if (task.getStep() == 60) {//
					if (MyChat.isOpenChat()) {
						MyChat.clickContinue();
					} else if (Tools2.inBox(3155, 3426, 3161, 3425, 1)) {
						Tools2.walkto(3160, 3435, 0);
					} else if (Tools2.inBox(3200, 3438, 3226, 3414)) {
						MyChat.talkNpc(5037, 1, 0);
					} else {
						Tools2.walkto(3214, 3425);
					}
				}
			} else {
				Login.login();
			}
		}
	}
	
	private boolean pull(int id, String action) {
		Chatbox.Tab.GAME.open();
		WorldTile xy = Query.gameObjects().idEquals(id).findFirst().get().getTile();
		if (!Tools2.distanceTo(xy.getX(), xy.getY(), 3)) {
			Tools2.walkScreento0(xy.getX(), xy.getY());
		} else if (Tools2.objectClick(id, "Inspect")) {
			Waiting.waitNormal(1350, 150);
			String tip = Tools2.interfaceText(162, 56, 0);
			if (tip.contains(action)) {
				return true;
			} else {
				Tools2.objectClick(id, "Pull");
			}
		}
		return false;
	}
}
