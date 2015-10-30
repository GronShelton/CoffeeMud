package com.planet_ink.coffee_mud.Libraries.interfaces;
import com.planet_ink.coffee_mud.core.interfaces.*;
import com.planet_ink.coffee_mud.core.*;
import com.planet_ink.coffee_mud.core.collections.*;
import com.planet_ink.coffee_mud.Abilities.interfaces.*;
import com.planet_ink.coffee_mud.Areas.interfaces.*;
import com.planet_ink.coffee_mud.Behaviors.interfaces.*;
import com.planet_ink.coffee_mud.CharClasses.interfaces.*;
import com.planet_ink.coffee_mud.Commands.interfaces.*;
import com.planet_ink.coffee_mud.Common.interfaces.*;
import com.planet_ink.coffee_mud.Exits.interfaces.*;
import com.planet_ink.coffee_mud.Items.interfaces.*;
import com.planet_ink.coffee_mud.Locales.interfaces.*;
import com.planet_ink.coffee_mud.MOBS.interfaces.*;
import com.planet_ink.coffee_mud.Races.interfaces.*;

import java.util.*;
/*
   Copyright 2005-2015 Bo Zimmerman

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

	   http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
/**
 * The Ability Mapper Library handles everything dealing with the relationship
 * between players, races, etc and Abilities (Skills, Spells, Prayers, etc).
 * The principle duty is to map the provider of player Abilities to those
 * Abilities, along with any requirements for being provided the skills,
 * and the condition the skill is in when it is received.
 * 
 * @author Bo Zimmerman
 *
 */
public interface AbilityMapper extends CMLibrary
{
	//TODO: Just use AbilityMapping class for all these methods, replace classes here with interfaces.
	
	
	/**
	 * Adds a mapping between a charclass, race, or whatever, and an Ability, by String Ability ID.
	 * Also allows specifying numerous other attributes.
	 * @see AbilityMapping
	 * @see AbilityMapper#makeAbilityMapping(String, int, String, int, int, String, boolean, boolean, boolean, List, String, Integer[])
	 * @see AbilityMapper#delCharAbilityMapping(String, String)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, boolean, List)
	 * @param ID the race ID(), charclass ID(), "All" is also acceptable.
	 * @param qualLevel the charclass or race player level at which one qualifies to receive the ability
	 * @param abilityID the Ability ID()
	 * @param autoGain true if the player/race automatically gets the ability, false if they must pay COSTs
	 * @return the finished AbilityMapping
	 */
	public AbilityMapping addCharAbilityMapping(String ID, int qualLevel, String abilityID, boolean autoGain);
	
	/**
	 * Adds a mapping between a charclass, race, or whatever, and an Ability, by String Ability ID.
	 * Also allows specifying numerous other attributes.
	 * @see AbilityMapping
	 * @see AbilityMapper#makeAbilityMapping(String, int, String, int, int, String, boolean, boolean, boolean, List, String, Integer[])
	 * @see AbilityMapper#delCharAbilityMapping(String, String)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, boolean)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, boolean, String)
	 * @param ID the race ID(), charclass ID(), "All" is also acceptable.
	 * @param qualLevel the charclass or race player level at which one qualifies to receive the ability
	 * @param abilityID the Ability ID()
	 * @param autoGain true if the player/race automatically gets the ability, false if they must pay COSTs
	 * @param preReqSkillsList String list of required Ability IDs with optional min. proff in parenthesis
	 * @return the finished AbilityMapping
	 */
	public AbilityMapping addCharAbilityMapping(String ID, int qualLevel, String abilityID, boolean autoGain, List<String> preReqSkillsList);
	
	/**
	 * Adds a mapping between a charclass, race, or whatever, and an Ability, by String Ability ID.
	 * Also allows specifying numerous other attributes.
	 * @see AbilityMapping
	 * @see AbilityMapper#makeAbilityMapping(String, int, String, int, int, String, boolean, boolean, boolean, List, String, Integer[])
	 * @see AbilityMapper#delCharAbilityMapping(String, String)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, boolean, List)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, boolean, List, String)
	 * @param ID the race ID(), charclass ID(), "All" is also acceptable.
	 * @param qualLevel the charclass or race player level at which one qualifies to receive the ability
	 * @param abilityID the Ability ID()
	 * @param autoGain true if the player/race automatically gets the ability, false if they must pay COSTs
	 * @param extraMask a zappermask for the player with any miscellaneough requirements
	 * @return the finished AbilityMapping
	 */
	public AbilityMapping addCharAbilityMapping(String ID, int qualLevel, String abilityID, boolean autoGain, String extraMasks);
	
	/**
	 * Adds a mapping between a charclass, race, or whatever, and an Ability, by String Ability ID.
	 * Also allows specifying numerous other attributes.
	 * @see AbilityMapping
	 * @see AbilityMapper#makeAbilityMapping(String, int, String, int, int, String, boolean, boolean, boolean, List, String, Integer[])
	 * @see AbilityMapper#delCharAbilityMapping(String, String)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, boolean, String)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, int, String, boolean)
	 * @param ID the race ID(), charclass ID(), "All" is also acceptable.
	 * @param qualLevel the charclass or race player level at which one qualifies to receive the ability
	 * @param abilityID the Ability ID()
	 * @param autoGain true if the player/race automatically gets the ability, false if they must pay COSTs
	 * @param preReqSkillsList String list of required Ability IDs with optional min. proff in parenthesis
	 * @param extraMask a zappermask for the player with any miscellaneough requirements
	 * @return the finished AbilityMapping
	 */
	public AbilityMapping addCharAbilityMapping(String ID, int qualLevel, String abilityID, boolean autoGain, List<String> preReqSkillsList, String extraMasks);
	
	/**
	 * Adds a mapping between a charclass, race, or whatever, and an Ability, by String Ability ID.
	 * Also allows specifying numerous other attributes.
	 * @see AbilityMapping
	 * @see AbilityMapper#makeAbilityMapping(String, int, String, int, int, String, boolean, boolean, boolean, List, String, Integer[])
	 * @see AbilityMapper#delCharAbilityMapping(String, String)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, boolean, List, String)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, int, boolean)
	 * @param ID the race ID(), charclass ID(), "All" is also acceptable.
	 * @param qualLevel the charclass or race player level at which one qualifies to receive the ability
	 * @param abilityID the Ability ID()
	 * @param defaultProficiency the initial proficiency at which this mapping bestows the ability
	 * @param defaultParam if the Ability allows parameters, these are the parameters this mapping gives
	 * @param autoGain true if the player/race automatically gets the ability, false if they must pay COSTs
	 * @return the finished AbilityMapping
	 */
	public AbilityMapping addCharAbilityMapping(String ID, int qualLevel, String abilityID, int defaultProficiency, String defaultParam, boolean autoGain);
	
	/**
	 * Adds a mapping between a charclass, race, or whatever, and an Ability, by String Ability ID.
	 * Also allows specifying numerous other attributes.
	 * @see AbilityMapping
	 * @see AbilityMapper#makeAbilityMapping(String, int, String, int, int, String, boolean, boolean, boolean, List, String, Integer[])
	 * @see AbilityMapper#delCharAbilityMapping(String, String)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, int, String, boolean)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, int, String, boolean, boolean)
	 * @param ID the race ID(), charclass ID(), "All" is also acceptable.
	 * @param qualLevel the charclass or race player level at which one qualifies to receive the ability
	 * @param abilityID the Ability ID()
	 * @param defaultProficiency the initial proficiency at which this mapping bestows the ability
	 * @param autoGain true if the player/race automatically gets the ability, false if they must pay COSTs
	 * @return the finished AbilityMapping
	 */
	public AbilityMapping addCharAbilityMapping(String ID, int qualLevel, String abilityID, int defaultProficiency, boolean autoGain);
	
	/**
	 * Adds a mapping between a charclass, race, or whatever, and an Ability, by String Ability ID.
	 * Also allows specifying numerous other attributes.
	 * @see AbilityMapping
	 * @see AbilityMapper#makeAbilityMapping(String, int, String, int, int, String, boolean, boolean, boolean, List, String, Integer[])
	 * @see AbilityMapper#delCharAbilityMapping(String, String)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, int, boolean)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, int, String, boolean, boolean, List, String)
	 * @param ID the race ID(), charclass ID(), "All" is also acceptable.
	 * @param qualLevel the charclass or race player level at which one qualifies to receive the ability
	 * @param abilityID the Ability ID()
	 * @param defaultProficiency the initial proficiency at which this mapping bestows the ability
	 * @param defaultParam if the Ability allows parameters, these are the parameters this mapping gives
	 * @param autoGain true if the player/race automatically gets the ability, false if they must pay COSTs
	 * @param secret true if this mapping is NOT available to Qualify and WillQualify commands, false if it is. 
	 * @return the finished AbilityMapping
	 */
	public AbilityMapping addCharAbilityMapping(String ID, int qualLevel, String abilityID, int defaultProficiency,
									  String defaultParam, boolean autoGain, boolean secret);

	/**
	 * Adds a mapping between a charclass, race, or whatever, and an Ability, by String Ability ID.
	 * Also allows specifying numerous other attributes.
	 * @see AbilityMapping
	 * @see AbilityMapper#makeAbilityMapping(String, int, String, int, int, String, boolean, boolean, boolean, List, String, Integer[])
	 * @see AbilityMapper#delCharAbilityMapping(String, String)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, int, String, boolean, boolean)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, int, int, String, boolean, boolean, List, String, Integer[])
	 * @param ID the race ID(), charclass ID(), "All" is also acceptable.
	 * @param qualLevel the charclass or race player level at which one qualifies to receive the ability
	 * @param abilityID the Ability ID()
	 * @param defaultProficiency the initial proficiency at which this mapping bestows the ability
	 * @param defaultParam if the Ability allows parameters, these are the parameters this mapping gives
	 * @param autoGain true if the player/race automatically gets the ability, false if they must pay COSTs
	 * @param secret true if this mapping is NOT available to Qualify and WillQualify commands, false if it is. 
	 * @param preReqSkillsList String list of required Ability IDs with optional min. proff in parenthesis
	 * @param extraMask a zappermask for the player with any miscellaneough requirements
	 * @return the finished AbilityMapping
	 */
	public AbilityMapping addCharAbilityMapping(String ID, int qualLevel, String abilityID, int defaultProficiency,
									  String defaultParam, boolean autoGain, boolean secret,
									  List<String> preReqSkillsList, String extraMask);
	
	/**
	 * Adds a mapping between a charclass, race, or whatever, and an Ability, by String Ability ID.
	 * Also allows specifying numerous other attributes.
	 * @see AbilityMapping
	 * @see AbilityMapper#makeAbilityMapping(String, int, String, int, int, String, boolean, boolean, boolean, List, String, Integer[])
	 * @see AbilityMapper#delCharAbilityMapping(String, String)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, int, String, boolean, boolean, List, String)
	 * @see AbilityMapper#addDynaAbilityMapping(String, int, String, int, String, boolean, boolean, String)
	 * @param ID the race ID(), charclass ID(), "All" is also acceptable.
	 * @param qualLevel the charclass or race player level at which one qualifies to receive the ability
	 * @param abilityID the Ability ID()
	 * @param defaultProficiency the initial proficiency at which this mapping bestows the ability
	 * @param maxProficiency the maximum proficiency that this mapping allows (100 default)
	 * @param defaultParam if the Ability allows parameters, these are the parameters this mapping gives
	 * @param autoGain true if the player/race automatically gets the ability, false if they must pay COSTs
	 * @param secret true if this mapping is NOT available to Qualify and WillQualify commands, false if it is. 
	 * @param preReqSkillsList String list of required Ability IDs with optional min. proff in parenthesis
	 * @param extraMask a zappermask for the player with any miscellaneough requirements
	 * @param costOverrides overrides of the CMProps-based cost formulas for gaining this skill
	 * @return the finished AbilityMapping
	 */
	public AbilityMapping addCharAbilityMapping(String ID, int qualLevel, String abilityID, int defaultProficiency,
									  int maxProficiency, String defaultParam, boolean autoGain, boolean secret,
									  List<String> preReqSkillsList, String extraMask, Integer[] costOverrides);

	/**
	 * Creates a raw Ability Mapping object.
	 * @see AbilityMapping
	 * @see AbilityMapper#delCharAbilityMapping(String, String)
	 * @see AbilityMapper#newAbilityMapping()
	 * @param ID the race ID(), charclass ID(), "All" is also acceptable.
	 * @param qualLevel the charclass or race player level at which one qualifies to receive the ability
	 * @param abilityID the Ability ID()
	 * @param defaultProficiency the initial proficiency at which this mapping bestows the ability
	 * @param maxProficiency the maximum proficiency that this mapping allows (100 default)
	 * @param defaultParam if the Ability allows parameters, these are the parameters this mapping gives
	 * @param autoGain true if the player/race automatically gets the ability, false if they must pay COSTs
	 * @param secret true if this mapping is NOT available to Qualify and WillQualify commands, false if it is. 
	 * @param isAllQualified true if all classes qualify for this skill, as from the All Qualifies list.
	 * @param preReqSkillsList String list of required Ability IDs with optional min. proff in parenthesis
	 * @param extraMask a zappermask for the player with any miscellaneough requirements
	 * @param costOverrides overrides of the CMProps-based cost formulas for gaining this skill
	 * @return the finished AbilityMapping
	 */
	public AbilityMapping makeAbilityMapping(String ID, int qualLevel, String abilityID, int defaultProficiency, int maxProficiency, String defaultParam, boolean autoGain,
			 boolean secret, boolean isAllQualified, List<String> preReqSkillsList, String extraMask, Integer[] costOverrides);

	/**
	 * Creates a new, blank ability mapping object
	 * @see AbilityMapping
	 * @see AbilityMapper#makeAbilityMapping(String, int, String, int, int, String, boolean, boolean, boolean, List, String, Integer[])
	 * @return a new, blank ability mapping object
	 */
	public AbilityMapping newAbilityMapping();
	
	/**
	 * Adds a mapping between a charclass, race, or whatever, and an Ability, by String Ability ID.
	 * Also allows specifying numerous other attributes.
	 * Substantially identical to methods like {@link AbilityMapper#addCharAbilityMapping(String, int, String, int, String, boolean, boolean, List, String)}
	 * except that the Each/global ability mappings are not initialized if this is the first class
	 * mapping, meaning it's best to call this at runtime instead of boot time.
	 * @see AbilityMapping
	 * @see AbilityMapper#makeAbilityMapping(String, int, String, int, int, String, boolean, boolean, boolean, List, String, Integer[])
	 * @see AbilityMapper#delCharAbilityMapping(String, String)
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, int, int, String, boolean, boolean, List, String, Integer[])
	 * @param ID the race ID(), charclass ID(), "All" is also acceptable.
	 * @param qualLevel the charclass or race player level at which one qualifies to receive the ability
	 * @param abilityID the Ability ID()
	 * @param defaultProficiency the initial proficiency at which this mapping bestows the ability
	 * @param defaultParam if the Ability allows parameters, these are the parameters this mapping gives
	 * @param autoGain true if the player/race automatically gets the ability, false if they must pay COSTs
	 * @param secret true if this mapping is NOT available to Qualify and WillQualify commands, false if it is. 
	 * @param extraMask a zappermask for the player with any miscellaneough requirements
	 * @return the finished AbilityMapping
	 */
	public AbilityMapping addDynaAbilityMapping(String ID, int qualLevel, String abilityID, int defaultProficiency,
			  						  String defaultParam, boolean autoGain, boolean secret, String extraMask);

	/**
	 * Removes the specified mapping between charclass, race, or whatever, and an Ability, by String ability ID.
	 * @see AbilityMapping
	 * @see AbilityMapper#makeAbilityMapping(String, int, String, int, int, String, boolean, boolean, boolean, List, String, Integer[])
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, int, int, String, boolean, boolean, List, String, Integer[])
	 * @see AbilityMapper#delCharMappings(String)
	 * @param ID the race ID(), charclass ID(), "All" is also acceptable.
	 * @param abilityID the Ability ID()
	 * @return the mapping removed
	 */
	public AbilityMapping delCharAbilityMapping(String ID, String abilityID);
	
	/**
	 * Removes all ability mappings for the given charclass, race, or whatever.
	 * @see AbilityMapping
	 * @see AbilityMapper#makeAbilityMapping(String, int, String, int, int, String, boolean, boolean, boolean, List, String, Integer[])
	 * @see AbilityMapper#addCharAbilityMapping(String, int, String, int, int, String, boolean, boolean, List, String, Integer[])
	 * @see AbilityMapper#delCharAbilityMapping(String, String)
	 * @param ID the race ID(), charclass ID(), "All" is also acceptable.
	 */
	public void delCharMappings(String ID);
	
	/**
	 * Adds to the list of allowed skills, expertises, etc that come from the requirements
	 * listed for the given skill.  Used mostly by the Expertise system, but also used
	 * by the class system to cross-reference skill requirements.
	 * @param ID the Ability ID of the skill gaining pre-requisites
	 * @param preReqSkillsList the formatted list of prereqs, typically Ability IDs.
	 * @param extraMask a zappermask of other requirements that a person must have for the skill
	 */
	public void addPreRequisites(String ID, List<String> preReqSkillsList, String extraMask);
	
	/**
	 * Returns an enumeration of all the AbilityMapping object for all the abilities the
	 * given class, race, whatever qualifies for ever.  Will include common (all qualified)
	 * abilities if specified.
	 * @see AbilityMapper.AbilityMapping
	 * @param ID the race ID(), charclass ID(), etc
	 * @param addAll true to include all-qualified abilities, false for just class unique
	 * @return an enumeration of AbilityMapping objects
	 */
	public Enumeration<AbilityMapping> getClassAbles(String ID, boolean addAll);
	
	/**
	 * Returns the lowest class level at which any class qualifies for the
	 * given ability, returning 0 if non found.
	 * @param abilityID the ability ID()
	 * @return the lowest qualifying level
	 */
	public int lowestQualifyingLevel(String abilityID);
	
	
	/**
	 * Returns the median lowest qualifying level for all abilities, given you
	 * an idea of the middle-skill-gaining levels, for some reason.
	 * @return the median lowest qualifying level for all abilities
	 */
	public int getCalculatedMedianLowestQualifyingLevel();
	
	/**
	 * Returns the AbilityIDs of all the skills qualified for by the given
	 * char class or race or whatever, at the given level, and optionally
	 * including the all-qualified skills.
	 * @param ID the charclass ID(), race ID(), or whatever
	 * @param checkAll true to check the All Qualifies list, or false otherwise
	 * @param level the specific level to check.
	 * @return the AbilityIDs of all the skills qualified for at that level
	 */
	public List<String> getLevelListings(String ID, boolean checkAll, int level);
	
	/**
	 * Returns the full AbilityMappings of all the skills qualified for by the given
	 * char class or race or whatever, at every level up to and including the 
	 * given level, and optionally excluding the all-qualified skills and
	 * non-gained skills.
	 * @param ID the charclass ID(), race ID(), or whatever
	 * @param level the specific level to check.
	 * @param ignoreAll true to ignore the All Qualifies list, or false otherwise
	 * @param gainedOnly true to only include the auto-gain-only skills, false otherwise  
	 * @return the AbilityIDs of all the skills qualified for at that level
	 */
	public List<AbilityMapping> getUpToLevelListings(String ID, int level, boolean ignoreAll, boolean gainedOnly);
	
	/**
	 * Returns the level at which the given class or race qualifies for the given ability ID(),
	 * optionally checking the All-Qualifies list or not.  Returns -1 for no match.
	 * @param ID the charclass ID(), race ID(), or whatever
	 * @param checkAll true to check the All Qualifies list, false to skip it
	 * @param abilityID the Ability ID() to find a level for
	 * @return the level at which the give class or race qualifies, or -1
	 */
	public int getQualifyingLevel(String ID, boolean checkAll, String abilityID);
	
	/**
	 * Returns the lowest class or player level at which the given mob (by race or 
	 * class) qualified for the given ability if any. Returns -1 for no match.
	 * This method is called when you are trying to guage how powerful the player
	 * is with the skill.
	 * @param studentM the mob, whose charclass ID(), race ID() are checked
	 * @param A the Ability to find a level for
	 * @return the best level at which the given mob qualified, or -1
	 */
	public int qualifyingLevel(MOB studentM, Ability A);
	
	/**
	 * Returns the lowest char class level at which the given mob (by race or 
	 * class) qualified for the given ability if any. Returns -1 for no match.
	 * This method is called when you are trying to guage how powerful the player
	 * is with the skill, and only care about class skills.
	 * @param studentM the mob, whose charclass ID() is checked
	 * @param A the Ability to find a level for
	 * @return the best char class level at which the given mob qualified, or -1
	 */
	public int qualifyingClassLevel(MOB studentM, Ability A);
	
	/**
	 * Returns whether the given Ability ID() represents a skill qualified for by
	 * any existing character class, including All-Qualified abilities.
	 * @param abilityID the ability ID()
	 * @return true if a class qualifies for it, false otherwise
	 */
	public boolean qualifiesByAnyCharClass(String abilityID);
	
	public boolean qualifiesOnlyByClan(MOB studentM, Ability A);
	public boolean qualifiesOnlyByRace(MOB studentM, Ability A);
	public CMObject lowestQualifyingClassRaceGovt(MOB studentM, Ability A);
	public boolean qualifiesByCurrentClassAndLevel(MOB studentM, Ability A);
	public boolean qualifiesOnlyByACharClass(MOB studentM, Ability A);
	public boolean qualifiesByLevel(MOB studentM, Ability A);
	public boolean qualifiesByLevel(MOB studentM, String abilityID);
	
	/**
	 * Returns whether the given class qualifies for the given ability.
	 * Does not check all-qualifies list, so this is only class (or race)
	 * specific qualifications.
	 * @see AbilityMapper#classOnly(MOB, String, String)
	 * @param classID the class ID(), race ID() or whatever
	 * @param abilityID the ability ID()
	 * @return true if the class qualifies for this ability
	 */
	public boolean classOnly(String classID, String abilityID);
	
	/**
	 * Returns whether the given class qualifies for the given ability.
	 * Does not check all-qualifies list, so this is only class (or race)
	 * specific qualifications.  Will also specifically check the given
	 * mobs class object with the given ID, which is strange.
	 * @see AbilityMapper#classOnly(String, String)
	 * @param mob the mob whose classes to also check
	 * @param classID the class ID(), race ID() or whatever to specifically check
	 * @param abilityID the ability ID() to use
	 * @return true if the class qualifies for this ability
	 */
	public boolean classOnly(MOB mob, String classID, String abilityID);
	
	/**
	 * Discovers whether the given ability is qualified for by a class that
	 * is available to the given theme id number.
	 * @see Area#THEME_ALLTHEMES
	 * @param abilityID the Ability ID()
	 * @param theme the theme code
	 * @param publicly true to disqualify skill-only masks, false to allow
	 * @return true if the ability is qualifies for by a char class of the theme
	 */
	public boolean availableToTheme(String abilityID, int theme, boolean publicly);
	
	/**
	 * Returns the total number of abilities mapped to a class or race or something.
	 * @return the total number of abilities mapped to a class or race or something.
	 */
	public int numMappedAbilities();
	
	/**
	 * Returns an iterator over the list of expertises and skills which having the given
	 * skill will allow.
	 * @param ableID the skill to get the allows list for
	 * @return an iterator over the list of expertises and skills
	 */
	public Iterator<String> getAbilityAllowsList(String ableID);
	
	/**
	 * Returns the list of things allowed by skill which the given class/race/whatever
	 * qualifies over their life, along with qualifying levels.  This is intended entirely for
	 * gathering expertises qualified for by class skills. 
	 * @param ID the charclass ID(), race ID(), or whatever
	 * @return the list of skill and skill qualifying information for that class
	 */
	public List<QualifyingID> getClassAllowsList(String ID);
	
	/**
	 * Returns the zapper mask that applies to the given class or race for the given 
	 * ability ID(), optionally checking the All-Qualifies list or not.  Returns null 
	 * for no match. The mask is checked against a potential learner of this skill.
	 * @see MaskingLibrary
	 * @param ID the charclass ID(), race ID(), or whatever
	 * @param checkAll true to check the All Qualifies list, false to skip it
	 * @param abilityID the Ability ID() to find a level for
	 * @return the zapper mask that applies
	 */
	public String getExtraMask(String ID, boolean checkAll, String abilityID);

	/**
	 * Returns the first applicable zapper mask that applies to the given mob for 
	 * the given ability. Returns null for nothing found. The mask is checked 
	 * against a potential learner of this skill.
	 * @see MaskingLibrary
	 * @param studentM the mob, whose clans, charclass ID(), race ID() are checked
	 * @param A the Ability to find a mask for
	 * @return the zapper mask that applies
	 */
	public String getApplicableMask(MOB studentM, Ability A);
	
	/**
	 * Returns the general zapper mask that defines the requirements to learn
	 * the given ability, by ID.  The mask is applied to the learner mob.
	 * @see MaskingLibrary
	 * @param A the Ability whose ID is looked up
	 * @return the zapper mask, or ""
	 */
	public String getCommonExtraMask(Ability A);
	
	/**
	 * Given a mob who wants to learn the given Ability skill, this
	 * method will check the mob (by race/class/whatever) against the
	 * ability they qualify for, determining if there are any pre-requisite
	 * skills needed to learn this skill.  If they are found, it returns
	 * those pre-requisites, specially coded.
	 * @param studentM the mob who wants to learn
	 * @param A the Ability the mob wants to learn
	 * @return any pre-requisites, or null for none.
	 */
	public DVector getUnmetPreRequisites(MOB studentM, Ability A);
	
	/**
	 * Returns the coded form of the skill prerequisites for the
	 * given ability.  Skill prerequisites are typically other
	 * skills needed to learn this one.  They are called Common
	 * because, for the given ability, they apply to everyone.
	 * @see AbilityMapper#getCommonPreRequisites(MOB, Ability)
	 * @see AbilityMapper#getUnmetPreRequisites(MOB, Ability)
	 * @see AbilityMapper#formatPreRequisites(DVector)
	 * @param A the ability to look for prerequisites to learn
	 * @return the coded skill prerequisites
	 */
	public DVector getCommonPreRequisites(Ability A);
	
	/**
	 * Returns the coded form of the skill prerequisites for the
	 * given ability that apply to the given mob by race or class.  
	 * Skill prerequisites are typically other skills needed to 
	 * learn this one.  
	 * @see AbilityMapper#getCommonPreRequisites(Ability)
	 * @see AbilityMapper#getUnmetPreRequisites(MOB, Ability)
	 * @see AbilityMapper#formatPreRequisites(DVector)
	 * @param mob the potential learner of the ability
	 * @param A the ability to look for prerequisites to learn
	 * @return the coded skill prerequisites
	 */
	public DVector getCommonPreRequisites(MOB mob, Ability A);
	
	/**
	 * Given a set of common Ability/skill pre-requisites
	 * for learning, coded, this method will return those
	 * pre-requisites formatted in a friendly, readable form.
	 * @see AbilityMapper#getCommonPreRequisites(Ability)
	 * @see AbilityMapper#getUnmetPreRequisites(MOB, Ability)
	 * @see AbilityMapper#getCommonPreRequisites(MOB, Ability)
	 * @param preReqs the coded pre-requisites for this skill
	 * @return a friendly readable description of those pre-reqs
	 */
	public String formatPreRequisites(DVector preReqs);
	public boolean getDefaultGain(String ID, boolean checkAll, String abilityID);
	public boolean getAllQualified(String ID, boolean checkAll, String abilityID);
	public AbilityMapping getAllAbleMap(String abilityID);
	public AbilityMapping getAbleMap(String ID, String abilityID);
	public boolean getSecretSkill(String ID, boolean checkAll, String abilityID);
	public boolean getAllSecretSkill(String abilityID);
	public boolean getSecretSkill(MOB mob, String abilityID);
	public boolean getSecretSkill(String abilityID);
	public AbilityLimits getCommonSkillLimit(MOB studentM);
	public AbilityLimits getCommonSkillLimit(MOB studentM, Ability A);
	public AbilityLimits getCommonSkillRemainder(MOB studentM, Ability A);
	public AbilityLimits getCommonSkillRemainders(MOB student);
	public Integer[] getCostOverrides(String ID, boolean checkAll, String abilityID);
	public Integer[] getAllCostOverrides(String abilityID);
	public Integer[] getCostOverrides(MOB mob, String abilityID);
	public Integer[] getCostOverrides(String abilityID);
	public String getDefaultParm(String ID, boolean checkAll, String abilityID);
	public String getPreReqStrings(String ID, boolean checkAll, String abilityID);
	public int getDefaultProficiency(String ID, boolean checkAll, String abilityID);
	public int getMaxProficiency(String ID, boolean checkAll, String abilityID);
	public int getMaxProficiency(String abilityID);
	public int getMaxProficiency(MOB mob, boolean checkAll, String abilityID);
	public List<Object> componentCheck(MOB mob, List<AbilityComponent> req);
	public int destroyAbilityComponents(List<Object> found);
	public String getAbilityComponentDesc(MOB mob, String AID);
	public String getAbilityComponentDesc(MOB mob, List<AbilityComponent> req);
	public Map<String, List<AbilityComponent>> getAbilityComponentMap();
	public String addAbilityComponent(String s, Map<String, List<AbilityComponent>> H);
	public String getAbilityComponentCodedString(String AID);
	public List<AbilityComponent> getAbilityComponents(String AID);
	public String getAbilityComponentDesc(MOB mob, List<AbilityComponent> req, int r);
	public void setAbilityComponentCodedFromCodedPairs(PairList<String,String> decodedDV, AbilityComponent comp);
	public PairList<String,String> getAbilityComponentCoded(AbilityComponent comp);
	public String getAbilityComponentCodedString(List<AbilityComponent> comps);
	public AbilityComponent createBlankAbilityComponent();
	public boolean isDomainIncludedInAnyAbility(int domain, int acode);
	public void alterAbilityComponentFile(String compID, boolean delete);
	public void saveAllQualifysFile(Map<String, Map<String,AbilityMapping>> newMap);
	public Map<String, Map<String,AbilityMapping>> getAllQualifiesMap(final Map<String,Object> cache);
	public Map<String, int[]> getHardOverrideManaCache();
	
	public static interface QualifyingID
	{
		public String ID();

		public int qualifyingLevel();

		public QualifyingID qualifyingLevel(int newLevel);
	}

	public static interface AbilityLimits
	{
		public int commonSkills();

		public AbilityLimits commonSkills(int newVal);

		public int craftingSkills();

		public AbilityLimits craftingSkills(int newVal);

		public int nonCraftingSkills();

		public AbilityLimits nonCraftingSkills(int newVal);

		public int specificSkillLimit();

		public AbilityLimits specificSkillLimit(int newVal);
	}

	public enum Cost
	{
		PRAC,
		TRAIN,
		MANA,
		PRACPRAC
	}
	
	public static interface AbilityMapping extends Cloneable
	{
		public String				ID();
		public AbilityMapping		ID(String newValue);
		public String				abilityID();
		public AbilityMapping		abilityID(String newValue);
		public int					qualLevel();
		public AbilityMapping		qualLevel(int newValue);
		public boolean				autoGain();
		public AbilityMapping		autoGain(boolean newValue);
		public int					defaultProficiency();
		public AbilityMapping		defaultProficiency(int newValue);
		public int					maxProficiency();
		public AbilityMapping		maxProficiency(int newValue);
		public String				defaultParm();
		public AbilityMapping		defaultParm(String newValue);
		public boolean				isSecret();
		public AbilityMapping		isSecret(boolean newValue);
		public boolean				isAllQualified();
		public AbilityMapping		isAllQualified(boolean newValue);
		public DVector				skillPreReqs();
		public AbilityMapping		skillPreReqs(DVector newValue);
		public String				extraMask();
		public AbilityMapping		extraMask(String newValue);
		public String				originalSkillPreReqList();
		public AbilityMapping		originalSkillPreReqList(String newValue);
		public Integer[]			costOverrides();
		public AbilityMapping		costOverrides(Integer[] newValue);
		public boolean				allQualifyFlag();
		public AbilityMapping		allQualifyFlag(boolean newValue);
		public Map<String, String>	extFields();
		public AbilityMapping		extFields(Map<String, String> newValue);
		public AbilityMapping		copyOf();
	}
}
