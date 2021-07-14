<template>
	<v-simple-table>
		<template v-slot:default>
			<thead>
				<tr>
					<th class="text-left">
						회원명
					</th>
					<th class="text-left">
						백신종류
					</th>
					<th class="text-left">
						가격
					</th>
					<th class="text-left">
						수량
					</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="item in desserts" :key="item.name">
					<td>{{ item.name }}</td>
					<td>{{ item.category }}</td>
					<td>{{ item.price }}</td>
					<td>{{ item.count }}</td>
				</tr>
			</tbody>
		</template>
	</v-simple-table>
</template>
<script>
export default {
	data() {
		return {
			desserts: [],
		};
	},
};
</script>
