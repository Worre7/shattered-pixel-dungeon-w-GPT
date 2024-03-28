/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2024 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.items.trinkets;

import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DimensionalSundial extends Trinket {

	{
		image = ItemSpriteSheet.SUNDIAL;
	}

	@Override
	protected int upgradeEnergyCost() {
		return 1+level(); //TODO
	}

	@Override
	public String desc() {
		return Messages.get(this, "desc", (int)(100*(enemySpawnMultiplier(buffedLvl())-1f)));
	}

	public static float spawnMultiplierAtCurrentTime(){
		Calendar cal = GregorianCalendar.getInstance();
		if (cal.get(Calendar.HOUR_OF_DAY) >= 21 || cal.get(Calendar.HOUR_OF_DAY) <= 6 ){
			return enemySpawnMultiplier();
		} else {
			return 1f;
		}
	}

	public static float enemySpawnMultiplier(){
		return enemySpawnMultiplier(trinketLevel(DimensionalSundial.class));
	}

	public static float enemySpawnMultiplier( int level ){
		if (level == -1){
			return 1f;
		} else {
			return 1.25f + 0.25f*level;
		}
	}
}