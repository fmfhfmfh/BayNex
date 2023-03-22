function java(){
	var text="//CODE MAKER Java\n";
	text += "import java.util.*;\n";
	text += "import java.lang.*;\n\n";
	text += "class Rextester{\n";
    text += "	    public static void main(String args[]){\n";
	text += '			System.out.println("Hello, World!");\n';
	text += "	    }\n";
	text +=	"}\n";
	return text;
}

function cs(){
	var text="//CODE MAKER C#\n";
	text += "using System;\n";
	text += "using System.Collections.Generic;\n";	
	text += "using System.Linq;\n";
	text += "using System.Text.RegularExpressions;\n";
	text += "namespace Rextester\n";
	text += "{\n";
	text += "    public class Program\n";
	text += "    {\n";
	text +=	"        public static void Main(string[] args)\n";
	text += "        {\n";
	text += "            Console.WriteLine(\"Hello, world!\");\n";
	text += "        }\n";
	text += "    }\n";
	text += "}\n";
	return text;
}

function python(){
	var text = "#CODE MAKER Python\n";
	text +=	"print \"Hello, world!\"\n";		
	return text;
}

function oracle(){
	var text ="--CODE MAEKR Oracle\n";
	text +=	"select banner as \"oracle version\" from v$version \n";
	return text;
}
