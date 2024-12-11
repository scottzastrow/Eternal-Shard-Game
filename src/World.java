/*
Java Code Author: Scott Zastrow
StoryLine Author: ChatGPT
Course: SEIS_610
Date: 12/04/24
Project: Hackathon
*/
import java.util.ArrayList;

public class World {
    ArrayList <Region> regions = new ArrayList<Region>();

    String name = "Elyndor";
    String description = """
                Elyndor is a once-flourishing world of magic, ancient ruins, and vibrant landscapes,
                now on the brink of decay. The world was once united by the eternal power of the Shards,
                fragments of a legendary artifact that sustained balance and harmony. However, the
                shards were scattered, and the Voidcaller—a dark entity from beyond the stars—seeks
                to harness their power to bring ruin to the land. Elyndor's diverse regions range from
                the mystical Kyrthael Forest, where ancient trees whisper secrets, to the desolate
                Ashen Wastes, corrupted by the Voidcaller’s presence. The land is both beautiful and
                perilous, with remnants of forgotten civilizations, ethereal creatures, and secrets
                waiting to be uncovered.
                
                The player, armed with one of the shards, must travel across Elyndor to reunite the
                pieces, confront the Voidcaller, and restore balance to the world before it is consumed by shadow.""";

    public World(){}
    public World(String name, String description){
        this.name =  name;
        this.description = description;
    }

    public void addRegions()
    {
        /////////////////////NEW REGION/////////////////////

        Region The_Forgotten_Forest = new Region();
        Inventory shard = new Inventory("Shard of Light","o	The starting item. Emits light, reveals secrets, and is crucial for visions and puzzles.",3,3);
        Inventory map = new Inventory("Map of Kyrthael","o	A map that reveals hidden paths in the Kyrthael Forest and marks locations of other shards.");
        The_Forgotten_Forest.addInventory(shard);
        The_Forgotten_Forest.addInventory(map);
        NPC forestSpirit = new NPC("Forest Spirit", 5, 1);
        forestSpirit.setDescription("""
                The dense foliage of Kyrthael Forest hums with life. Shafts of sunlight
                filter through the emerald canopy, illuminating patches of vibrant moss
                and tangled roots. The air is thick with the scent of earth and the sound
                of rustling leaves, but an unnatural stillness creeps in as you step into
                a secluded glade.
                
                At the center of the glade, a faint, shimmering light hovers, shifting
                colors like a living prism. Flowers around it bloom and wither in seconds,
                caught in an endless cycle of life and decay. The Forest Spirit manifests,
                its form fluid and otherworldly—a humanoid figure woven from vines, petals,
                and wisps of glowing mist. Its eyes shimmer like dew-drops caught in moonlight,
                filled with mischief and ancient wisdom.
                
                1.	Fight: Engage the Forest Spirit in battle.
                2.	Outwit: Solve a riddle that will allow you to pass without conflict.
                3.	Pacify: Pay out some 5 coins to satisfy the Forest Spirit.
                """);
        The_Forgotten_Forest.addNPC(forestSpirit);
        NPC bramble = new NPC("Bramble Warden", 10,3);
        bramble.setDescription("""
                The path through Kyrthael Forest narrows, the air thick with an unnatural
                stillness. Towering brambles arch overhead, their thorns glinting faintly
                as if alive. A low growl rumbles through the silence, resonating like thunder
                in the bones. The forest seems to hold its breath as the player steps into a
                vast clearing, the ground carpeted with tangled roots and shards of broken
                stone—remnants of an ancient battle.
                
                In the center of the clearing stands the Bramble Warden, a hulking beast made
                entirely of twisted vines, bark, and thorny tendrils. Its glowing emerald eyes
                pierce the shadows, radiating both intelligence and primal fury. The creature’s
                form shifts subtly, as if the forest itself is breathing through it. Around its
                neck dangles a charm of carved wood, faintly pulsing with an eerie green light
                the source of its power.
                
                1.	Fight: Engage Bramble Warden in battle.
                2.	Outwit: Solve a riddle that will allow you to pass without conflict.
                3.	Pacify: Pay out some 7 coins to satisfy the Bramble Warden.
                """);
        The_Forgotten_Forest.addNPC(bramble);
        The_Forgotten_Forest.setRegionName("Kyrthael Forest");
        The_Forgotten_Forest.setRegionDescription("""
                The Kyrthael Forest is a dense, mystical woodland where the trees
                whisper ancient secrets. The air is thick with magic, and faint trails
                wind through towering trees. A shimmering mist clings to the ground,
                and strange creatures can be heard rustling in the underbrush. Hidden
                paths lead deeper into the forest, where untold mysteries await.""");
        Puzzle SunMoon = new Puzzle();
        SunMoon.setAnswer("The Sun and the Moon");
        SunMoon.setQuestion("""
                Two companions I have,
                One leads the day and the other night,
                One gives warmth and light,
                The other only shines with borrowed might.
                They chase each other without a race,
                Though one can never take the other's place.
                Who are they?"
                """);
        SunMoon.setHint("Hint: They are always together, but never quite the same.");
        SunMoon.setAltAnswerOne("Mars and Venus");
        SunMoon.setAltAnswerTwo("Mork and Mindy");
        SunMoon.setAltAnswerThree("Peppy le Pew and his Girlfriend");
        The_Forgotten_Forest.addPuzzle(SunMoon);
        Puzzle Silence = new Puzzle();
        Silence.setAnswer("Silence");
        Silence.setQuestion("""
                I speak without words,
                I have no mouth,
                I can bring you peace,
                Or leave you full of doubt.
                I am everywhere and nowhere at once,
                But you cannot touch or hear my voice.
                What am I?""");
        Silence.setHint("Hint: Silence is Golden.");
        Silence.setAltAnswerOne("Time");
        Silence.setAltAnswerTwo("A Shadow");
        Silence.setAltAnswerThree("Thoughts");
        The_Forgotten_Forest.addPuzzle(Silence);

        regions.add(The_Forgotten_Forest);
/////////////////////NEW REGION/////////////////////
        Region Wisphering_Mtns = new Region();
        Inventory shardMtns = new Inventory("Shard of Light","o	The starting item. Emits light, reveals secrets, and is crucial for visions and puzzles.",3,3);
        Wisphering_Mtns.addInventory(shardMtns);
        Inventory runes = new Inventory("Ancient Runes","o	Mysterious symbols used to unlock doors and activate puzzles in the Whispering Mountains.",1,3);
        Wisphering_Mtns.addInventory(runes);

        NPC guide = new NPC("Mysterious Guide", 10, 2);
        guide.setDescription("""
                You ascend through a narrow, jagged path high in the Whispering Mountains,
                the wind howling through the crags, carrying faint echoes of forgotten voices.
                Dark clouds gather above, and the air grows thick with an unsettling chill. As
                you continue your journey, you come across a clearing—a rare moment of tranquility
                among the harsh, unforgiving terrain.
                
                In the center of the clearing, a figure stands, cloaked in tattered robes that blend
                seamlessly with the shadows. The figure’s face is obscured, but a faint, golden light
                emanates from beneath the hood, casting eerie reflections on the stone around them. A
                walking staff adorned with strange carvings rests in his hand, a symbol of some ancient,
                forgotten power.
                
                1.	Fight: Engage the Mysterious Guide in battle.
                2.	Outwit: Solve a riddle that will allow you to pass without conflict.
                3.	Pacify: Pay out some 5 coins to satisfy the Bramble Warden.
                """);
        Wisphering_Mtns.addNPC(guide);
        NPC guardians = new NPC("Spectral Guardians", 10, 3);
        guardians.setDescription("""
                You now venture deeper into the Whispering Mountains, the terrain growing steeper and more ominous.
                The air grows colder, and the distant echo of an eerie, wind-blown melody chills the bones. Jagged
                cliffs rise on either side, and the sky is choked with dark clouds, as if the very heavens are
                suffocating the land below. The atmosphere is thick with tension, each step forward seeming to pull
                you deeper into an unsettling silence.
                
                In the distance, faint flickers of pale light dance through the shadows—just enough to catch your eye.
                As you approach, you enter a narrow gorge where the stone walls are covered in ancient carvings, depicting
                long-forgotten warriors. Their eyes, once proud and defiant, now seem hollow, as though the stone itself has
                absorbed the spirits of those who once walked this land. The wind howls through the gorge, carrying
                whispers—voices from a time long past.
                
                Suddenly, the ground trembles beneath your feet, and the whispers crescendo into a sharp, piercing wail. Emerging
                from the mist are the Spectral Guardians—ethereal figures in tattered armor, their forms translucent and flickering
                like dying embers. They move with eerie precision, their weapons glowing faintly with the same ghostly light. Each
                guardian is an embodiment of an ancient soldier, their faces obscured by the weight of their duty.
                
                1.	Fight: Engage the Spectral Guardians in battle.
                2.	Outwit: Solve a riddle that will allow you to pass without conflict.
                3.	Pacify: Pay out some 7 coins to satisfy the Bramble Warden.
                """);
        Wisphering_Mtns.addNPC(guardians);
        Wisphering_Mtns.setRegionName("Whispering Mountains");
        Wisphering_Mtns.setRegionDescription("""
                A harsh, wind-swept region high above the forest, the Whispering Mountains
                are named for the eerie voices that echo through the jagged peaks. The snow
                here is often tinged with blue, and the cliffs are sharp, with dangerous paths
                leading up to the summit. Ancient ruins and shrines dot the landscape, and ghostly
                figures can sometimes be seen drifting in the cold air""");
        Puzzle wind = new Puzzle();
        wind.setAnswer("Wind");
        wind.setQuestion("""
                I cannot be seen, but you feel my breath,
                I can tear down trees, yet am softer than death.
                I whisper and howl, yet leave no trace,
                I come and go without a face.
                What am I?""");
        wind.setHint("Hint: I am a force of nature, unseen yet ever-present.");
        wind.setAltAnswerOne("A Memory");
        wind.setAltAnswerTwo("Echoes");
        wind.setAltAnswerThree("Time");
        Wisphering_Mtns.addPuzzle(wind);
        Puzzle water = new Puzzle();
        water.setAnswer("Water");
        water.setQuestion("""
                I flow without legs,
                I am born in the sky,
                I touch everything,
                But never ask why.
                I am never the same,
                Yet always return.
                What am I?""");
        water.setHint("Hint: I am a natural cycle, always moving, never the same.");
        water.setAltAnswerOne("Dreams");
        water.setAltAnswerTwo("Energy");
        water.setAltAnswerThree("A Song");
        Wisphering_Mtns.addPuzzle(water);
        regions.add(Wisphering_Mtns);
/////////////////////NEW REGION/////////////////////
        Region Ashen_Wastes = new Region();
        Inventory shardAsh = new Inventory("Shard of Light","o	The starting item. Emits light, reveals secrets, and is crucial for visions and puzzles.",3,3);
        Ashen_Wastes.addInventory(shardAsh);
        Inventory shackles = new Inventory("Shackles of the Forgotten","o	tEnchanted chains needed to either free or bind the Shackled One in the Ashen Wastes.",3,3);
        Ashen_Wastes.addInventory(shackles);
        NPC shackled = new NPC("Shackled One", 5,1);
        shackled.setDescription("""
                Yuo continue your journey through the Ashen Wastes, a desolate and barren land ravaged by the
                Voidcaller’s corruption. The air is thick with the stench of sulfur and decay, and the sun barely
                pierces the oppressive clouds, casting an eerie, dim light over the twisted landscape. The ground
                is cracked, dry, and stained with dark, lifeless patches where nothing grows. Jagged rock formations
                loom in the distance, their shapes distorted, like the twisted remnants of some ancient, ruined city.
                
                As you navigates this hostile environment, you come across a strange and unnerving sight: an ancient,
                rusted iron gate, half-buried in the ashen earth. Chains, dark and twisted, spill from the gate and
                snake across the ground, some leading into the depths of a dark, foreboding cavern. The air around the
                gate crackles with malevolent energy, the ground beneath the chains faintly pulsing with an unnatural rhythm.
                
                Suddenly, from the shadows of the cavern, a low, tortured groan reverberates through the air. The wind picks
                up, carrying with it the sound of clinking chains, like a prisoner stirring in their bonds. You feel a shiver
                run down your spine. Something, or someone, is trapped.
                
                From the darkness, a figure steps forward—emerging from the cavern in the midst of swirling
                dust and spectral mist. The Shackled One is a towering, monstrous figure, bound by chains that
                wrap around its body, some embedded deep into its flesh. The chains are ancient, encrusted with
                rust and dark, ominous markings that glow faintly in the dim light. The figure’s face is obscured
                by a metal mask, its features hidden behind a tortured, silent expression. The Shackled One’s body
                seems to ripple with energy, as though the chains themselves are alive, pulling and twisting at its form.
                
                As it steps into the light, its movements are slow but deliberate, as if each step causes immense
                pain. The chains groan with a resonance that echoes across the wasteland, and the figure’s heavy
                breathing can be heard beneath the clinking of metal.
                
                1.	Fight: Engage the Shackled One in battle.
                2.	Outwit: Solve a riddle that will allow you to pass without conflict.
                3.	Pacify: Pay out some 5 coins to satisfy the Bramble Warden.
                """);
        Ashen_Wastes.addNPC(shackled);
        NPC voidCaller = new NPC("Voidcaller", 10,10);
        voidCaller.setDescription("""
                You approach the heart of the Ashen Wastes, a place so corrupted by the Voidcaller’s influence
                that the very landscape seems to twist and writhe with malevolent energy. The air is thick with
                dark mists that churn and shift like living shadows, carrying an unbearable weight—each breath
                feels like inhaling smoke. The ground is cracked and uneven, fissures running deep into the earth,
                emitting an eerie, purple glow that pulses with an unnatural rhythm. The sky is a roiling mass of
                swirling dark clouds, crackling with energy, casting the entire realm in a twilight that never ends.
                
                In the distance, a colossal structure rises—an ancient, dark fortress with obsidian spires that pierce
                the sky like jagged teeth. It stands at the very center of the wasteland, a monument to the Voidcaller’s
                twisted reign. The fortress seems to hum with an almost palpable dark power, the very stone glowing with
                cursed symbols etched into its surface. The winds carry whispers of forgotten names, and the oppressive
                atmosphere makes every step toward it feel like a slow descent into madness.
                
                As you approach the gates of the fortress, you can feel the Voidcaller’s presence, like a cold, suffocating
                grip tightening around your heart. A voice, deep and filled with ancient malice, echoes in their mind:
                "You are too late, mortal. The world will fall, and with it, the last remnants of hope."
                
                The Voidcaller is an entity born from the very essence of the void itself, the force that seeks to undo all
                creation. His hands are long and clawed, crackling with dark energy, and his voice is like thunder—low,
                reverberating, and deeply resonant, the sound of time itself unraveling. The air around him distorts, reality
                itself bending and warping, as if the laws of nature cannot hold in his presence.
                
                Around him, the ground is covered in shadowy tendrils that stretch out like the roots of a great tree, pulling
                everything into the darkness. Dark magic pulses from him, corrupting everything it touches, turning the very
                air into a toxic, oppressive force.
                
                1.	Fight: Engage the Voidcaller in battle.
                2.	Outwit: Solve a riddle that will allow you to pass without conflict.
                3.	Pacify: Pay out some 7 coins to satisfy the Bramble Warden.
                """);
        Ashen_Wastes.addNPC(voidCaller);
        Ashen_Wastes.setRegionName("Ashen_Wastes");
        Ashen_Wastes.setRegionDescription("""
                The Ashen Wastes are a desolate, barren landscape. Blackened earth stretches as far
                as the eye can see, and the air is thick with the scent of sulfur. Scattered ruins
                of ancient buildings lie half-buried in the soot, and the occasional thunderclap
                echoes in the distance. Shadows move unnaturally, and the land feels heavy with the
                corruption of the Void.""");
        Puzzle traveler = new Puzzle();
        traveler.setAnswer("Time");
        traveler.setQuestion("""
                I walk without feet,
                I carry no load,
                I make no sound, yet travel far.
                I leave no trace of where I’ve been,
                But everywhere I go, I can be seen.
                What am I?""");
        traveler.setHint("Hint: Time heals all wounds.");
        traveler.setAltAnswerOne("The Horizon");
        traveler.setAltAnswerTwo("Electricity");
        traveler.setAltAnswerThree("A Thought");
        traveler.setAltAnswerOne("A Reflection");
        traveler.setAltAnswerTwo("A Beam of Light");
        traveler.setAltAnswerThree("A Shadow");
        Ashen_Wastes.addPuzzle(traveler);
        Puzzle fire = new Puzzle();
        fire.setAnswer("Fire");
        fire.setQuestion("""
                I am always hungry, I must always be fed,
                The finger I touch, will soon turn red.
                I can devour all that you see,
                Yet I can be quenched by the smallest plea.
                What am I?""");
        fire.setHint("Hint: Goodness Gracious Great Balls of Fire!");
        fire.setAltAnswerOne("Desire");
        fire.setAltAnswerTwo("Greed");
        fire.setAltAnswerThree("A Disease");
        Ashen_Wastes.addPuzzle(fire);
        regions.add(Ashen_Wastes);
    }
}
